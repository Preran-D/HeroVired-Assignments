public class AssignmentOperator {

  public static void main(String[] args) {
    int num1 = 10;
    int num = num1 + 2;
    System.out.println("After addition: num = " + num);
    num -= 4;
    System.out.println("After subtraction: num = " + num);
    num *= 7;
    System.out.println("After multiplication: num = " + num);
    num /= 4;
    System.out.println("After division: num = " + num);
    num %= 3;
    System.out.println("After modulus: num = " + num);
  }
}
