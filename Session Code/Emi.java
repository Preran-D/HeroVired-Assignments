import java.util.Scanner;

public class Emi {

  public static void main(String[] args) {
    try (Scanner scan = new Scanner(System.in)) {
      //loan amount
      System.out.println("Enter the loan amount");
      double a = scan.nextDouble();

      // number of months
      System.out.println("Enter number of years");
      double n = scan.nextDouble() * 12;

      // interest rate is 6.
      double r = 0.06 / 12;

      double f1 = Math.pow((1 + r), n);

      //formula
      double monthlyPayment = a / ((f1 - 1) / (r * f1));
      System.out.printf("Monthly Payment amount is: %.2f", monthlyPayment);

      System.out.println();

      double totalInterest = Math.abs(a - (monthlyPayment * n));
      System.out.printf("Total interset: %.2f", totalInterest);
    }
  }
}