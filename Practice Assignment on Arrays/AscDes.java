import java.util.Arrays;

public class AscDes {

  public static void main(String[] args) {
    int[] arrNum = { 23, 21, 44, 32, 12 };

    ascending(arrNum);
    System.out.println("Ascending order: " +Arrays.toString(arrNum));
    descending(arrNum);
    System.out.println("Descending order: "+Arrays.toString(arrNum));
  }

  private static void ascending(int[] arrNum) {
    for (int i = 0; i < arrNum.length - 1; i++) {
      for (int j = 0; j < arrNum.length - 1 - i; j++) {
        if (arrNum[j] > arrNum[j + 1]) {
          swap(arrNum, j, j + 1);
        }
      }
    }
  }

  private static void descending(int[] arrNum) {
    for (int i = 0; i < arrNum.length - 1; i++) {
      for (int j = 0; j < arrNum.length - 1 - i; j++) {
        if (arrNum[j] < arrNum[j + 1]) {
          swap(arrNum, j, j + 1);
        }
      }
    }
  }

  private static void swap(int[] arrNum, int i, int j) {
    int temp = arrNum[i];
    arrNum[i] = arrNum[j];
    arrNum[j] = temp;
  }
}
