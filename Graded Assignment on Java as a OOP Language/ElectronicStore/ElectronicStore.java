package ElectronicStore;

import java.util.Scanner;

public class ElectronicStore {

  public static void main(String[] args) {
    SmallElectronicStoreInventoryManagement inventory = new SmallElectronicStoreInventoryManagement();

    Product p1 = new Product(
      "Laptop",
      "Intel i5, 8GB RAM, 256GB SSD",
      100000,
      10
    );
    Product p2 = new Product(
      "Smartphone",
      "6.5 inch, 128GB storage, 4000mAh battery",
      30000,
      20
    );
    Product p3 = new Product(
      "Headphones",
      "Over-ear, noise-canceling",
      4000,
      30
    );

    inventory.addProduct(p1);
    inventory.addProduct(p2);
    inventory.addProduct(p3);

    Scanner scanner = new Scanner(System.in);
    int choice;

    do {
      System.out.println("\n--- Small Electronics Store ---");
      System.out.println("1. View Product List");
      System.out.println("2. View Product Count");
      System.out.println("3. View Product Details");
      System.out.println("4. Edit Product Details");
      System.out.println("5. Update Inventory");
      System.out.println("0. Exit");
      System.out.print("Enter your choice: ");
      choice = scanner.nextInt();

      switch (choice) {
        case 1:
          inventory.prodcutList();
          break;
        case 2:
          System.out.print("Enter product name: ");
          scanner.nextLine();
          String productName = scanner.nextLine();
          inventory.productCount(productName);
          break;
        case 3:
          System.out.print("Enter product name: ");
          scanner.nextLine();
          productName = scanner.nextLine();
          inventory.viewProductDetails(productName);
          break;
        case 4:
          System.out.print("Enter product name: ");
          scanner.nextLine();
          productName = scanner.nextLine();
          if (inventory.checkProduct(productName)) {
            System.out.print("Enter new specification: ");
            String specification = scanner.nextLine();
            System.out.print("Enter new cost: ");
            double cost = scanner.nextDouble();
            inventory.editProduct(productName, specification, cost);
          } else {
            System.out.println("Product not found");
          }

          break;
        case 5:
          System.out.print("Enter product name: ");
          scanner.nextLine();
          productName = scanner.nextLine();
          System.out.print(
            "Enter quantity (positive for addition, negative for deletion): "
          );
          int quantity = scanner.nextInt();
          inventory.updateInventory(productName, quantity);
          break;
        case 0:
          System.out.println("Exited Small Electronic Store");
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
          break;
      }
    } while (choice != 0);

    scanner.close();
  }
}
