import java.util.Scanner;

public class RestaurantApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GetFileData getFileData = new GetFileData();

        String reset = GetFileData.ANSI_RESET;
        String blue = GetFileData.ANSI_Blue;
        System.out.println(blue + "\n\n* * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("*        Welcome to Quick-Bites Restaurant      *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * *"+reset);

        while (true) {
            System.out.println("\n~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.println("1. Place Order ");
            System.out.println("2. Update Status (Delivered / Cancel) ");
            System.out.println("3. Daily Report ");
            System.out.println("4. Exit ");
            System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.print("Select an option: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> getFileData.placeOrder();
                    case 2 -> getFileData.cancelOrder();
                    case 3 -> getFileData.trackCollections();
                    case 4 -> {
                        System.out.println(blue+"* * * * * * * * * * * * * * * * * * * * * * * * *");
                        System.out.println("*               Thank you                       *");
                        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * *"+reset);
                        return;
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.nextLine();
            }
        }
    }
}
