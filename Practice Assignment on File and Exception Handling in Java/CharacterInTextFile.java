import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CharacterInTextFile {

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("fileName: ");
      String filename = scanner.nextLine();

      try (BufferedReader rd = new BufferedReader(new FileReader(filename))) {
        int ch = 0;

        String line;
        while ((line = rd.readLine()) != null) {
          ch += line.length();
        }
        System.out.println(ch);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
