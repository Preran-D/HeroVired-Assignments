import java.util.Scanner;

public class PrimeNumber {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Please enter the number: ");
    int number = scanner.nextInt();

    boolean isPrime = checkPrime(number);

    String result = isPrime ? "is a prime number." : "is NOT a prime number.";
    System.out.println("The given number " +number + " " + result);

    scanner.close();
  }

  public static boolean checkPrime(int number) {
    if (number <= 1) {
      return false;
    }

    for (int i = 2; i <= Math.sqrt(number); i++) {
      if (number % i == 0) {
        return false;
      }
    }

    return true;
  }
}
