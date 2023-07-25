package May21;

public class StringProblems {

  public static void main(String[] args) {
    String s1 =
      "Java is a high-level class-based object-oriented programming language that is designed to have as few implementation dependencies as possible";
    String[] s2 = s1.split(" ");
    System.out.println(s1);

    System.out.println("Number of Words: " + s2.length);
    System.out.println("Number of character including spaces: " + s1.length());

    int a = 0;
    for (String words : s2) {
      a += words.length();
    }
    System.out.println("Number of character excluding spaces: " + a);
    System.out.println("Number of spaces: " + (s1.length() - a));
    System.out.println();

    // *********************************************************************************************************

    // Palindrome
    String s3 = "madam";
    String s4 = "";

    // Without string builder
    for (int i = s3.length() - 1; i >= 0; i--) {
      s4 += s3.charAt(i);
    }
    String palindrome = s3.equals(s4)
      ? "is a palindrome"
      : "is not a palindrome";

    System.out.printf("%s %s", s3, palindrome);
    System.out.println();

    // *********************************************************************************************************

    // String Builder
    String s5 = "Time";
    StringBuilder s6 = new StringBuilder(s5);
    System.out.println("String is reversed: " + s6.reverse());

    // *********************************************************************************************************

    // Palindrome Case 2
    String s7 = "mad am";
    String s8 = s7.replaceAll(" ", ""); // Remove spaces from s7
    String s12 = new StringBuilder(s8).reverse().toString(); // Reverse s8

    String palindrome1 = s8.equals(s12)
      ? "is a palindrome"
      : "is not a palindrome";

    System.out.println();
    System.out.println(s7);
    System.out.printf("%s %s%n", s12, palindrome1);
    System.out.println();

    // *********************************************************************************************************

    // Vowels
    String s9 = "Encyclopedia";
    String s10 = s9.toLowerCase();
    String vowels = "aeiou";
    int count = 0;
    for (int i = 0; i < s10.length(); i++) {
      char c = s10.charAt(i);
      if (vowels.indexOf(c) != -1) {
        count++;
      }
    }

    System.out.println("number of vowels in " + s9 + " is " + count);
    System.out.println();

    // *********************************************************************************************************

    String s13 = "Helo, World!";
    String d = "";

    for (int i = 0; i < s13.length(); i++) {
      char c = s13.charAt(i);
      if (c != ' ' && s13.indexOf(c, i + 1) != -1 && s13.indexOf(c) != -1) {
        d += c;
      }
    }
    System.out.println("Duplicate characters: " + d);

    // *********************************************************************************************************

    String s14 = "Hello, World!";
    int[] charCount = new int[256];

    for (char c : s14.toCharArray()) {
      if (Character.isWhitespace(c)) {
        continue;
      }

      charCount[c]++;
    }

    for (int i = 0; i < charCount.length; i++) {
      if (charCount[i] > 1) {
        System.out.println(
          "Character: " + (char) i + ", Frequency: " + charCount[i]
        );
      }
    }
    // *********************************************************************************************************

  }
}
