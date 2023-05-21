import java.util.Scanner;

public class SmallLargeAverage {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter the first number: ");
    int a = scan.nextInt();

    System.out.print("Enter the second number: ");
    int b = scan.nextInt();

    System.out.print("Enter the third number: ");
    int c = scan.nextInt();

    int largest = Math.max(a, Math.max(b, c));
    int smallest = Math.min(a, Math.min(b, c));
    int average = (a + b + c) / 3;

    // Printing the results
    System.out.println("The Largest Number: " + largest);
    System.out.println("The Smallest Number: " + smallest);
    System.out.println("Average of all three numbers: " + average);

    scan.close();
  }
}
