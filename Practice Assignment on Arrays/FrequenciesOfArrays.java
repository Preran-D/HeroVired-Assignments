public class FrequenciesOfArrays {

  public static void main(String[] args) {
    int[] arrSuperSet = { 3, 1, 3, 4, 1, 2, 1, 8, 3, 2, 1, 1, 3, 2, 3, 3, 4 };
    int[] arrSubSet = { 1, 2, 3, 5, 9 };

    for (int i : arrSubSet) {
      int count = 0;
      for (int j : arrSuperSet) {
        if (i == j) {
          count++;
        }
    }
    System.out.printf("Frequency of %d : %d \n", i, count);
    }
  }
}
