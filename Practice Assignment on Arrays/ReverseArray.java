public class ReverseArray {

  public static void main(String[] args) {
    int[] arrNum = { 31, 42, 25, 21, 56, 61, 13, 45, 76, 55 };
    for (int i = 0; i < arrNum.length / 2; i++) {
      int temp = arrNum[i];
      arrNum[i] = arrNum[arrNum.length - 1 - i];
      arrNum[arrNum.length - 1 - i] = temp;
    }
    System.out.println("Reversed array:");
    for (int num : arrNum) {
      System.out.print(num + " ");
    }
  }
}
