import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class GetFileData {

    public final List<Order> orders;
    public final List<CollectionReport> report;
    private final List<MenuItem> menu;
    String orderPath = "order.csv";
    List<MenuItem> selectedItems = new ArrayList<>();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_Blue = "\u001B[34m";
    public static final String ANSI_Red = "\u001B[31m";
    public static final String ANSI_Green = "\u001B[32m";
    public static final String ANSI_Yellow = "\u001B[33m";

    public GetFileData() {
        this.menu = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.report = new ArrayList<>();
    }
    private boolean menuLoaded = false;
    private void load_Display_Menu() {
        if (menuLoaded) {
            return;
        }
        String menuPath = "food.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(menuPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 3) {
                    int menuId = Integer.parseInt(values[0]);
                    String name = values[1];
                    double price = Double.parseDouble(values[2]);
                    MenuItem item = new MenuItem(menuId, name, price);
                    menu.add(item);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void displayMenu(){
        load_Display_Menu();
        menuLoaded = true;
        System.out.println(ANSI_Blue+"\nQuick-Bites Menu"+ANSI_RESET);
        System.out.println("----------------------------------");
        System.out.printf(" %-3s   %-15s  %-3s %n", "ID", "Items", "Price");
        System.out.println("----------------------------------");
        for (MenuItem item : menu) {
            System.out.printf("%-2s  %-18s - ₹ %.0f %n", item.getMenuId(), item.getName(), item.getPrice());
        }
        System.out.println("----------------------------------");
    }
    public MenuItem findMenuItemById(int itemId) {
        for (MenuItem item : menu) {
            if (item.getMenuId() == itemId) {
                return item;
            }
        }
        return null;
    }
    public void placeOrder() {


        displayMenu();

        Set<Integer> selectedMenuIds = new HashSet<>();

        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.print("Enter the menu item ID to add to the order (0 to finish): ");
            int itemId = scanner.nextInt();

            if (itemId == 0) {
                break;
            }

            if (selectedMenuIds.contains(itemId)) {
                System.out.println(ANSI_Yellow + "You have already selected this menu item.\nPlease choose a different one." + ANSI_RESET);
                continue;
            }

            MenuItem selectedItem = findMenuItemById(itemId);

            if (selectedItem != null) {
                System.out.print("Enter quantity for " + selectedItem.getName() + ": ");
                int qty = scanner.nextInt();

                if (qty > 0) {
                    selectedItem.setQuantity(qty);
                    selectedItems.add(selectedItem);
                    selectedMenuIds.add(itemId);
                } else {
                    System.out.println("Invalid quantity. Please enter a valid quantity greater than 0.");
                }
            } else {
                System.out.println("Invalid menu item ID. Please try again.");
            }
        }

        if (!selectedItems.isEmpty()) {
            int nextOrderId = getNextOrderId();
            Order order = new Order(nextOrderId, getCurrentDate(), calculateTotalAmount(selectedItems), "Pending", selectedItems);
            orders.add(order);
            displayOrderItems(order);
            System.out.println(ANSI_Green + "Order placed successfully!" + ANSI_RESET);
            writeToOrder(order);
        } else {
            System.out.println("No items selected. Order not placed.");
        }
    }
    public int getNextOrderId() {
        int nextOrderId = 1;
        String orderPath = "order.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(orderPath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 1) {
                    int orderId = Integer.parseInt(values[0]);
                    nextOrderId = orderId + 1;
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
        return nextOrderId;
    }
    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate = new Date();
        return dateFormat.format(currentDate);
    }
    private double calculateTotalAmount(List<MenuItem> items) {
        double total = 0;
        for (MenuItem item : items) {
            total += item.calculateTotal();
        }
        return total;
    }
    private void displayOrderItems(Order order) {
        System.out.println(ANSI_Red + "\nOrder ID: " + order.orderId() + ANSI_RESET);
        System.out.println("Ordered Items:");
        System.out.println("---------------------------------------------------------");
        System.out.printf(" %-15s  %-8s  %-8s  %-8s %n", "Item Name", "Quantity", "Price", "Total");
        System.out.println("---------------------------------------------------------");
        for (MenuItem item : order.orderedItems()) {
            double itemTotal = item.getPrice() * item.getQuantity();
            System.out.printf(" %-15s  %-8d  ₹%.2f   ₹%.2f %n", item.getName(), item.getQuantity(), item.getPrice(), itemTotal);

        }
        System.out.println("---------------------------------------------------------");
        System.out.println("Total Order Amount : ₹" + ANSI_Red + order.totalAmount() + ANSI_RESET);
    }
    private void writeToOrder(Order order) {
        StringBuilder stringBuilder = new StringBuilder();
        for (MenuItem str : selectedItems) {
            stringBuilder.append(str);
            stringBuilder.append(" ~~~ ");
        }
        String concatenatedString = stringBuilder.toString();

        boolean writeHeader = !new File(orderPath).exists();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(orderPath, true))) {
            if (writeHeader) {
                writer.write("Order ID,Status,Total Amount,Date,Items,");
                writer.newLine();
            }

            writer.write(order.orderId() + "," + order.status() + "," + order.totalAmount() + "," + order.date() + "," + concatenatedString + ",");
            writer.newLine();
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
    public void cancelOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ANSI_Blue+"\nUpdate Order Status"+ANSI_RESET);
        while (true) {
            List<Integer> pendingOrderIds = getPendingOrderIds();

            if (pendingOrderIds.isEmpty()) {
                System.out.println("\nNo pending orders found." + ANSI_Green + "\nPlace Order" + ANSI_RESET);
                return;
            }

            System.out.println(ANSI_Red + "\nPending Orders:" + ANSI_RESET);
            for (int orderId : pendingOrderIds) {
                System.out.println("Order ID: " + orderId);
            }

            System.out.print("\nEnter the Pending Order ID \n(or enter '0' to exit): ");
            int orderId = scanner.nextInt();

            if (orderId == 0) {
                System.out.println("Exiting cancel order.");
                return;
            }

            OrderStatus currentStatus = getCurrentOrderStatus(orderId);

            if (currentStatus == null) {
                System.out.println("Order ID not found. No changes were made.");
                continue;
            }

            if (currentStatus != OrderStatus.PENDING) {
                System.out.println(ANSI_Red + "Only Pending Order ID.\n" + ANSI_RESET);
                continue;
            }

            int choice;
            while (true) {
                System.out.println("1. Delivered");
                System.out.println("2. Cancel Order");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1 || choice == 2) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter 1 for 'Delivered Successful' or 2 for 'Cancel Order'.");
                }
            }

            OrderStatus status = (choice == 1) ? OrderStatus.SUCCESSFUL : OrderStatus.CANCELLED;
            updateStatus(String.valueOf(orderId), String.valueOf(status));
        }
    }
    private List<Integer> getPendingOrderIds() {
        List<Integer> pendingOrderIds = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(orderPath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 4) {
                    int currentOrderId = Integer.parseInt(values[0]);
                    String currentStatusStr = values[1];
                    OrderStatus currentStatus = OrderStatus.valueOf(currentStatusStr.toUpperCase());
                    if (currentStatus == OrderStatus.PENDING) {
                        pendingOrderIds.add(currentOrderId);
                    }
                }
            }
        } catch (IOException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        return pendingOrderIds;
    }
    private OrderStatus getCurrentOrderStatus(int orderId) {
        try (BufferedReader br = new BufferedReader(new FileReader(orderPath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 4) {
                    int currentOrderId = Integer.parseInt(values[0]);
                    String currentStatusStr = values[1];
                    OrderStatus currentStatus = OrderStatus.valueOf(currentStatusStr.toUpperCase());
                    if (currentOrderId == orderId) {
                        return currentStatus;
                    }
                }
            }
        } catch (IOException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
    private void updateStatus(String targetID, String status) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(orderPath))) {
            String line;
            String header = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 4) {
                    int orderId = Integer.parseInt(values[0]);
                    if (String.valueOf(orderId).equals(targetID)) {
                        String updatedLine = values[0] + "," + status + "," + values[2] + "," + values[3] + "," + values[4] + ",";
                        lines.add(updatedLine);
                        System.out.println(ANSI_Green + "Order status updated successfully." + ANSI_RESET);
                    } else {
                        lines.add(line);
                    }
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(orderPath))) {
                writer.write(header);
                for (String updatedLine : lines) {
                    writer.newLine();
                    writer.write(updatedLine);
                }
                writer.newLine();
            } catch (IOException e) {
                System.err.println("An error occurred while writing to the file: " + e.getMessage());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void trackCollections() {

        Map<String, Double> collectionsByDate = new HashMap<>();
        Set<Integer> pendingOrders = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(orderPath))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 5) {
                    int orderId = Integer.parseInt(values[0]);
                    String status = values[1];
                    double totalAmount = Double.parseDouble(values[2]);
                    String dateStr = values[3];

                    if (status.equalsIgnoreCase("Successful")) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        Date orderDate = dateFormat.parse(dateStr);
                        String formattedDate = dateFormat.format(orderDate);

                        collectionsByDate.put(formattedDate, collectionsByDate.getOrDefault(formattedDate, 0.0) + totalAmount);
                    } else if (status.equalsIgnoreCase("Pending")) {
                        pendingOrders.add(orderId);
                    }
                }
            }



            writeReportToCSV(collectionsByDate);

            Scanner scanner = new Scanner(System.in);
            System.out.println(ANSI_Blue+"\nREPORT"+ANSI_RESET);
            if (!pendingOrders.isEmpty()) {
                System.out.println(ANSI_Red + "* * * Note: There are pending orders. * * * \nORDER IDs: " + pendingOrders + ANSI_RESET);
            }
            System.out.println("Choose an option:");
            System.out.println("1. Show all data");
            System.out.println("2. Show by date");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                displayAllDataFromReport();
            } else if (choice == 2) {
                fetchReportByDate();
            } else {
                System.out.println(ANSI_Red+"Invalid choice. No data displayed."+ANSI_RESET);
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
    private void displayAllDataFromReport() {
        String reportPath = "report.csv";
        TreeMap<String, Double> collectionsByDate = new TreeMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(reportPath))) {
            String line;
            br.readLine();

            System.out.println(ANSI_Blue + "\nDate-wise Collection Report " + ANSI_RESET);

            boolean reportEmpty = true;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String date = parts[0];
                    double totalCollection = Double.parseDouble(parts[1]);
                    collectionsByDate.put(date, totalCollection);
                }
            }

            for (Map.Entry<String, Double> entry : collectionsByDate.entrySet()) {
                String date = entry.getKey();
                double totalCollection = entry.getValue();
                CollectionReport reportEntry = new CollectionReport(date, totalCollection);
                System.out.println(reportEntry);
                reportEmpty = false;
            }

            if (reportEmpty) {
                System.out.println("No Status successful for collections to report.");
            }

        } catch (IOException e) {
            System.err.println("An error occurred while reading the report file: " + e.getMessage());
        }
    }

    private void fetchReportByDate() {
        String reportPath = "report.csv";

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nEnter a specific date to fetch the collection report\n (dd-MM-yyyy) or '0' to Exit: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("0")) {
                break;
            }

            try (BufferedReader br = new BufferedReader(new FileReader(reportPath))) {
                String line;
                br.readLine();

                boolean found = false;

                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 2 && parts[0].equals(userInput)) {
                        System.out.println("Collection for " + userInput + ": ₹" + parts[1]);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("No data found for the specified date.");
                }
            } catch (IOException e) {
                System.err.println("An error occurred while reading the report file: " + e.getMessage());
            }
        }
    }
    private void writeReportToCSV(Map<String, Double> collectionsByDate) {
        String reportPath = "report.csv";

        TreeMap<String, Double> sortedCollectionsByDate = new TreeMap<>(collectionsByDate);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportPath))) {
            writer.write("Date,Total Collection");
            writer.newLine();

            for (Map.Entry<String, Double> entry : sortedCollectionsByDate.entrySet()) {
                String date = entry.getKey();
                double totalCollection = entry.getValue();
                writer.write(date + "," + totalCollection);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing the report file: " + e.getMessage());
        }
    }

    public enum OrderStatus {
        PENDING, SUCCESSFUL, CANCELLED
    }
}
