import java.util.Scanner;

public class InventoryManagement {

  private static String[] productNames = {
    "Mobile",
    "Laptop",
    "Tablet",
    "Portable HDD",
    "Bluetooth Headphone",
    "Smart-watch",
    "Digital Camera",
    "Portable Power Bank",
    "Printer",
    "Wireless Router",
  };

  private static String[] specifications = {
    "Operating System - Android | RAM - 4GB | Storage - 64GB | Screen Size - 6 inches | Camera - 12MP | Battery Life - 3000mAh.",
    "Windows 10 | Processor - Intel Core i5 | RAM - 8GB | Storage - 256GB SSD | Screen Size - 15.6 inches | Graphics - NVIDIA GeForce GTX 1650.",
    "iOS | Screen Size - 10.2 inches | Storage - 128GB | Processor - Apple A12 Bionic | Battery Life - 10 hours | Touch ID.",
    "Storage Capacity - 1TB | USB 3.0 interface | Compact and lightweight design.",
    "Wireless connectivity | Battery Life - 20 hours | Noise cancellation feature | Foldable design.",
    "Compatibility - iOS and Android | Water Resistance | Battery Life - 2 days | GPS, fitness tracking, sleep monitoring, step counting, and more",
    "Megapixel - 24MP | Optical Zoom - 10x | Video Recording - 4K | Touchscreen Display | Wi-Fi connectivity.",
    "Capacity - 10,000mAh | Dual USB ports | Fast charging support | Compact and lightweight.",
    "Laser | Print Speed - 30 pages per minute | Connectivity - USB and Ethernet | Duplex printing.",
    "Wireless Standard - Wi-Fi 6 (802.11ax) | Dual-band | Data Transfer Rate - up to 1.8 Gbps | Multiple Ethernet ports | Parental controls.",
  };

  private static double[] costs = {
    500.0,
    101.0,
    700.0,
    100.0,
    50.0,
    200.0,
    300.0,
    50.0,
    200.0,
    100.0,
  };

  private static int[] quantities = { 50, 20, 30, 10, 15, 25, 12, 40, 8, 5 };

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(
      "-----------------------------------------------------------------------------------------------------"
    );
    System.out.println("Welcome to the SmartPoint Electronics Store");
    System.out.println(
      "-----------------------------------------------------------------------------------------------------"
    );

    boolean exit = false;

    while (!exit) {
      System.out.println("Menu:");
      System.out.println("1. View the complete list of our products");
      System.out.println("2. Check the available count for a specific product");
      System.out.println(
        "3. View the specifications and details of a specific product"
      );
      System.out.println("4. Modify the details of a specific product");
      System.out.println("5. Update the inventory for a specific product");
      System.out.println("0. Exit");
      System.out.print("Please choose an option from the above menu: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          displayProductList();
          break;
        case 2:
          checkProductCount(scanner);
          break;
        case 3:
          viewProductDetails(scanner);
          break;
        case 4:
          editProduct(scanner);
          break;
        case 5:
          updateInventory(scanner);
          break;
        case 0:
          System.out.println("Thank you for visiting SmartPoint!");
          exit = true;
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
          break;
      }

      if (!exit) {
        System.out.println();
        System.out.print(
          "Enter 'Y' to return to the main menu or 'N' to exit: "
        );
        String continueChoice = scanner.nextLine();
        if (continueChoice.equalsIgnoreCase("N")) {
          System.out.println("Thank you for visiting SmartPoint!");
          exit = true;
        }
      }
    }

    scanner.close();
  }

  private static void displayProductList() {
    System.out.println(
      "-----------------------------------------------------------------------------------------------------"
    );
    System.out.println("List of all Products");
    System.out.println(
      "-----------------------------------------------------------------------------------------------------"
    );

    System.out.printf("%-12s %-20s \n", "Product ID", "Product Name");

    for (int i = 0; i < productNames.length; i++) {
      System.out.printf("%-12d %-20s \n", i + 101, productNames[i]);
    }
  }

  private static void checkProductCount(Scanner scanner) {
    System.out.print("Enter the product ID: ");
    int productId = scanner.nextInt();
    scanner.nextLine();

    if (isValidProductId(productId)) {
      int quantity = quantities[productId - 101];
      System.out.println(
        "-----------------------------------------------------------------------------------------------------"
      );
      System.out.println("Product Count");
      System.out.println(
        "-----------------------------------------------------------------------------------------------------"
      );
      System.out.println(productId + " " + productNames[productId - 101]);
      System.out.println("Total available count: " + quantity);
    } else {
      System.out.println("Invalid product ID.");
    }
  }

  private static void viewProductDetails(Scanner scanner) {
    System.out.print("Enter the product ID: ");
    int productId = scanner.nextInt();
    scanner.nextLine();

    if (isValidProductId(productId)) {
      System.out.println(
        "-----------------------------------------------------------------------------------------------------"
      );
      System.out.println("Product Details");
      System.out.println(
        "-----------------------------------------------------------------------------------------------------"
      );
      System.out.println(productId + " " + productNames[productId - 101]);
      System.out.println(
        "Total available count: " + quantities[productId - 101]
      );
      System.out.println(specifications[productId - 101]);
      System.out.println("Cost: " + costs[productId - 101]);
    } else {
      System.out.println("Invalid product ID.");
    }
  }

  private static void editProduct(Scanner scanner) {
    System.out.print("Enter the product ID: ");
    int productId = scanner.nextInt();
    scanner.nextLine();

    if (isValidProductId(productId)) {
      System.out.println(
        "-----------------------------------------------------------------------------------------------------"
      );
      System.out.println("Edit Product");
      System.out.println(
        "-----------------------------------------------------------------------------------------------------"
      );

      System.out.println("Product Name: " + productNames[productId - 101]);
      System.out.println("1. Edit Specifications");
      System.out.println("2. Edit Cost");
      System.out.println("3. Edit Quantity");
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          System.out.print("Enter new specifications: ");
          String newSpecifications = scanner.nextLine();
          specifications[productId - 101] = newSpecifications;
          System.out.println(
            "-----------------------------------------------------------------------------------------------------"
          );
          System.out.println(productId + " " + productNames[productId - 101]);
          System.out.println(
            "New Specifications: " + specifications[productId - 101]
          );
          System.out.println("Specifications updated successfully.");
          System.out.println(
            "-----------------------------------------------------------------------------------------------------"
          );

          break;
        case 2:
          System.out.print("Enter new cost: ");
          double newCost = scanner.nextDouble();
          scanner.nextLine();
          costs[productId - 101] = newCost;
          System.out.println(
            "-----------------------------------------------------------------------------------------------------"
          );
          System.out.println(productId + " " + productNames[productId - 101]);
          System.out.println("New cost: " + costs[productId - 101]);
          System.out.println("Cost updated successfully.");
          System.out.println(
            "-----------------------------------------------------------------------------------------------------"
          );

          break;
        case 3:
          System.out.print("Enter new quantity: ");
          int newQuantity = scanner.nextInt();
          scanner.nextLine();
          quantities[productId - 101] = newQuantity;
          System.out.println(
            "-----------------------------------------------------------------------------------------------------"
          );
          System.out.println(productId + " " + productNames[productId - 101]);
          System.out.println("New Quantity: " + quantities[productId - 101]);
          System.out.println("Quantity updated successfully.");
          System.out.println(
            "-----------------------------------------------------------------------------------------------------"
          );

          break;
        default:
          System.out.println("Invalid choice.");
          break;
      }
    } else {
      System.out.println("Invalid product ID.");
    }
  }

  private static void updateInventory(Scanner scanner) {
    System.out.print("Enter the product ID: ");
    int productId = scanner.nextInt();
    scanner.nextLine();

    if (isValidProductId(productId)) {
      System.out.println(
        "-----------------------------------------------------------------------------------------------------"
      );
      System.out.println("Update Inventory");
      System.out.println(
        "-----------------------------------------------------------------------------------------------------"
      );
      System.out.println("Product Name: " + productNames[productId - 101]);
      System.out.println("1. Add inventory");
      System.out.println("2. Subtract inventory");
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          System.out.printf(
            "Current available inventory for %s %d: \n",
            productNames[productId - 101],
            quantities[productId - 101]
          );
          System.out.print("Please enter the count to be added: ");
          int quantityToAdd = scanner.nextInt();
          scanner.nextLine();
          quantities[productId - 101] += quantityToAdd;
          System.out.println(
            "-----------------------------------------------------------------------------------------------------"
          );

          System.out.println(productId + " " + productNames[productId - 101]);
          System.out.println(
            "Total avaiable count: " + quantities[productId - 101]
          );
          System.out.println("Inventory updated successfully.");
          System.out.println(
            "-----------------------------------------------------------------------------------------------------"
          );

          break;
        case 2:
          System.out.printf(
            "Current available inventory for %s %d: \n",
            productNames[productId - 101],
            quantities[productId - 101]
          );
          System.out.print("Please enter the count to be subtracted: ");
          int quantityToSubtract = scanner.nextInt();
          scanner.nextLine();

          if (quantities[productId - 101] >= quantityToSubtract) {
            quantities[productId - 101] -= quantityToSubtract;

            System.out.println(
              "-----------------------------------------------------------------------------------------------------"
            );

            System.out.println(productId + " " + productNames[productId - 101]);
            System.out.println(
              "Total avaiable count: " + quantities[productId - 101]
            );
            System.out.println("Inventory updated successfully.");
            System.out.println(
              "-----------------------------------------------------------------------------------------------------"
            );
          } else {
            System.out.println("Insufficient inventory to subtract.");
          }
          break;
        default:
          System.out.println("Invalid choice.");
          break;
      }
    } else {
      System.out.println("Invalid product ID.");
    }
  }

  private static boolean isValidProductId(int productId) {
    return productId >= 101 && productId < 101 + productNames.length;
  }
}
