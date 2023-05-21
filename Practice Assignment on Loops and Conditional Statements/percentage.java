import java.util.Scanner;

public class percentage {

  public static void main(String[] args) {
    System.out.println("Enter Your Marks: ");
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    float percentage = (float) n / 7;
    String gpa = percentage < 59
      ? "Grade F, GPA = 0.0"
      : percentage < 69
        ? "Grade D, GPA = 1.0"
        : percentage < 79
          ? "Grade C, GPA = 2.0"
          : percentage < 89 ? "Grade B, GPA = 3.0" : "Grade A, GPA = 4.0";
    System.out.printf("Percentage: %.2f%%", percentage);
    System.out.println();
    System.out.println(gpa);
    scan.close();
  }
}
