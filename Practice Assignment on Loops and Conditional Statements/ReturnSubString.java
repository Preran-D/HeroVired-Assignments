public class ReturnSubString {

  public static void main(String[] args) {
    String stringName = "Mangalyaan";
    int startIndex = 0;
    int endIndex = 5;

    String substring = stringName.substring(startIndex, endIndex + 1);

    System.out.printf("Substring of %s from %d to %d is : %s ", stringName,startIndex,endIndex, substring);
  }
}
