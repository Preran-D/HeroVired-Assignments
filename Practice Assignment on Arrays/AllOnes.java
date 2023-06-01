import java.util.Arrays;

public class AllOnes {

  public static void main(String[] args) {
    int[] arrNum = { 3, 1, 4, 1, 2, 1, 8, 3, 2, 1 };
    int lastIndex = arrNum.length - 1;
    for (int i = 0; i < lastIndex; i++) {
      if (arrNum[i] == 1) {
        swap(arrNum, i, lastIndex);
        lastIndex--;
        i--;
      }
    }
    System.out.println(Arrays.toString(arrNum));
  }

  private static void swap(int[] arrNum, int i, int j) {
    int temp = arrNum[i];
    arrNum[i] = arrNum[j];
    arrNum[j] = temp;
  }
}
