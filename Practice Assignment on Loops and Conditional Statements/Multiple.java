import java.util.Scanner;

public class Multiple {

  public static void main(String[] args) {
    try (Scanner scan = new Scanner(System.in)) {
        System.out.println("Enter the number of multiplication table");
        int n = scan.nextInt();
        for (int i = 1; i <= 10; i++) {
          System.out.printf("%d x %d = %d", n, i, n * i);
          System.out.println();
        }
    }
  }
}
