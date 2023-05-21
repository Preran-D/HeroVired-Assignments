public class DiamondTrinagle {

  public static void main(String[] args) {
    int rows = 5;
    for (int n = 1; n < 2 * rows; n += 2) {
      int totalColsInRow = n > rows ? 2 * rows - n : n;

      int noOfSpaces = rows - totalColsInRow;
      for (int s = 0; s < noOfSpaces; s += 2) {
        System.out.print(" ");
      }

      for (int col = 0; col < totalColsInRow; col++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
