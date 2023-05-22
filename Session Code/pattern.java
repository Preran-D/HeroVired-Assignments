import java.util.Scanner;

public class pattern {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Select a pattern to print:");
    System.out.println("1. Pyramid");
    System.out.println("2. Diamond");
    System.out.println("3. Number Pattern");
    System.out.println("4. Floyd's Triangle ");
    System.out.println("5. Print All ");

    System.out.print("Enter your choice (1-4): ");
    int choice = scan.nextInt();
    scan.close();
    switch (choice) {
      case 1:
        {
          System.out.println("Pyramid Pattern: ");
          printPyramid();
          break;
        }
      case 2:
        {
          System.out.println("Diamond Pattern: ");
          printDiamond();
          break;
        }
      case 3:
        {
          System.out.println("Number Pattern: ");
          printNumberPattern();
          break;
        }
      case 4:
        {
          System.out.println("Floyd's Triangle Pattern: ");
          printFloydPattern();
          break;
        }
      case 5:
        {
          System.out.println("Pyramid Pattern: ");
          printPyramid();
          System.out.println("Diamond Pattern: ");
          printDiamond();
          System.out.println("Number Pattern: ");
          printNumberPattern();
          System.out.println("Floyd's Triangle Pattern: ");
          printFloydPattern();
          break;
        }
      default:
        {
          System.out.println("Invalid Choice");
        }
    }
  }

  public static void printPyramid() {
    int row = 7;
    for (int i = 0; i < row; i++) {
      for (int k = row - i; k > 1; k--) {
        System.out.print(" ");
      }
      for (int j = 0; j < i; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }

  public static void printDiamond() {
    int midrow = 5;
    for (int row = 1; row < 2 * midrow; row++) {

      int totalColsInRow = row > midrow ? 2 * midrow - row : row;

      int noOfSpaces = midrow - totalColsInRow;
      for (int s = 0; s < noOfSpaces; s++) {
        System.out.print(" ");
      }

      for (int col = 0; col < totalColsInRow; col++) {
        System.out.print(" *");
      }
      System.out.println();
    }
  }

  public static void printNumberPattern() {
    int row = 7;
    for (int i = 1; i <= row; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(j + " ");
      }
      System.out.println();
    }
  }

  private static void printFloydPattern() {
    int row = 7;
    int num = 1;
    for (int i = 1; i <= row; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(num + " ");
        num++;
      }
      System.out.println();
    }
  }
}
