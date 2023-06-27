package ElectronicStore;

import java.util.ArrayList;

public class SmallElectronicStoreInventoryManagement {

  private ArrayList<Product> products;

  public SmallElectronicStoreInventoryManagement() {
    products = new ArrayList<>();
  }

  public void addProduct(Product product) {
    products.add(product);
  }

  public void deleteProduct(Product product) {
    products.remove(product);
  }

  public void prodcutList() {
    int count = 0;
    System.out.println("------Product Lists------");
    for (Product product : products) {
      count++;
      System.out.printf(" %d. %-10s  \n", count, product.getName());
    }
    System.out.println();
  }

  public void productCount(String productName) {
    for (Product product : products) {
      if (product.getName().equalsIgnoreCase(productName)) {
        System.out.println("------Product Count------");
        System.out.println(
          product.getName() + "\t Count : " + product.getCount()
        );
      }
    }
    System.out.println();
  }

  public void viewProductDetails(String productName) {
    for (Product product : products) {
      if (product.getName().equalsIgnoreCase(productName)) {
        System.out.println("-----Product Details-----");
        System.out.println(product.getName() + " Specifications");
        System.out.println("Specs : " + product.getSpecification());
        System.out.println(" Cost : Rs." + product.getCost());
        System.out.println("Count : " + product.getCount());
        System.out.println();
        return;
      }
    }
    System.out.println(productName + " Not Found!");
    System.out.println();
  }

  public void editProduct(String productName, String specs, double cost) {
    for (Product product : products) {
      if (product.getName().equalsIgnoreCase(productName)) {
        product.setSpecification(specs);
        product.setCost(cost);
        System.out.println("Product details updated successfully.");
        return;
      }
    }
    System.out.println("Product not found.");
  }

  public void updateInventory(String productName, int quantity) {
    for (Product product : products) {
      if (product.getName().equalsIgnoreCase(productName)) {
        int newCount = product.getCount() + quantity;
        if (newCount >= 0) {
          product.setCount(newCount);
          System.out.println("Inventory updated successfully.");
        } else {
          System.out.println("Insufficient quantity for deletion.");
        }
        return;
      }
    }
    System.out.println("Product not found.");
  }

  public boolean checkProduct(String productName) {
    for (Product product : products) {
      if (product.getName().equalsIgnoreCase(productName)) {
        return true;
      }
    }
    return false;
  }
}
