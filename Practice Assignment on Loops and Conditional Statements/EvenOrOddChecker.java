import java.util.Scanner;

public class EvenOrOddChecker {

  static boolean checkEvenOdd(int n) {
    return ((n & 1) != 1);
  }

  public static void main(String[] args) {
    try (Scanner scan = new Scanner(System.in)) {
      String choice = "y";
      while (choice.equals("y")) {
        System.out.println("Please enter the number:");
        int a = scan.nextInt();
        scan.nextLine(); 

        String b = checkEvenOdd(a) ? "is an Even number" : "is a Odd number";

        System.out.printf("The given number - %d %s%n",a, b);

        System.out.println("Do you want to continue: Y / N");
        choice = scan.nextLine().toLowerCase();
      }
      scan.close();
    }
  }
}
