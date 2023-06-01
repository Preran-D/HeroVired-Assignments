import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class UniqueLibrary {

  private static String[][] books = {
    { "101", "HTML and CSS", "Jon Duckett", "Available", "Null", "Null" },
    { "102", "JavaScript: The Good Parts", "Douglas C", "Available", "Null", "Null" },
    { "103", "Learning Web Design", "Jennifer N", "CP2014", "23-May-2023", "Null" },
    { "104", "Responsive Web Design", "Ben Frain", "EC3142", "17-May-2023", "Null" },
  };

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(
      "----------------------------------------------------------------------------------"
    );
    System.out.println("Welcome to the Unique Library");
    System.out.println(
      "----------------------------------------------------------------------------------"
    );  

    boolean exit = false;

    while (!exit) {
      System.out.println("1. View the complete list of Books");
      System.out.println("2. Issue a Book");
      System.out.println("3. Return a Book");
      System.out.println("4. Exit");
      System.out.print("Please choose an option from the above menu: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          listOfBooks();
          break;
        case 2:
          issueBook(scanner);
          break;
        case 3:
          returnBook(scanner);
          break;
        case 4:
          System.out.println("Thank you for visiting Unique Library!");
          exit = true;
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
          break;
      }

      if (!exit) {
        System.out.println();
        System.out.print(
          "Enter 'Y' to return to the main menu or 'N' to exit: "
        );
        String continueChoice = scanner.nextLine();
        if (continueChoice.equalsIgnoreCase("N")) {
          System.out.println("Thank you for visiting Unique Library!");
          exit = true;
        }
      }
    }

    scanner.close();
  }

  private static void listOfBooks() {
    System.out.println();
    System.out.printf(
      "|%-10s| %-27s| %-20s| %-15s| %-12s|%n",
      "Book ID",
      "Book Title",
      "Author",
      "Availability",
      "Issue Date"
    );
    System.out.println(
      "----------------------------------------------------------------------------------------------"
    );
    for (String[] book : books) {
      System.out.printf(
        "|%-10s| %-27s| %-20s| %-15s| %-12s|%n",
        book[0],
        book[1],
        book[2],
        book[3],
        book[4]
      );
    }
  }

  private static void issueBook(Scanner scanner) {
    System.out.println(
      "----------------------------------------------------------------------------------"
    );
    System.out.println("Issue the Book");
    System.out.println(
      "----------------------------------------------------------------------------------"
    );

    System.out.print("Enter the Book ID: ");
    String bookId = scanner.nextLine();

    boolean bookFound = false;

    for (String[] book : books) {
      if (bookId.equals(book[0])) {
        if (book[3].equalsIgnoreCase("Available")) {
          boolean confirm = false;
          System.out.println(
            book[0] + " " + book[1] + " " + book[2] + ": " + book[3]
          );

          while (!confirm) {
            System.out.print("Enter Student ID: ");
            String studentId = scanner.nextLine();
            System.out.print("Enter 'C' to confirm: ");
            String confirmed = scanner.nextLine();
            if (confirmed.equalsIgnoreCase("C")) {
              book[3] = studentId.toUpperCase();
              book[4] = getCurrentDate();
              confirm = true;
            }
          }

          System.out.println("Book Issued Successfully");
          System.out.println("Issue Date: " + book[4]);
        } else {
          System.out.println("Book is not available for issuing.");
        }
        bookFound = true;
        break;
      }
    }

    if (!bookFound) {
      System.out.println("Book not found!");
    }
  }

  private static String getCurrentDate() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
    String currentDate = LocalDate.now().format(formatter);
    return currentDate;
  }

  private static void returnBook(Scanner scanner) {
    System.out.println(
      "----------------------------------------------------------------------------------"
    );
    System.out.println("Return the Book");
    System.out.println(
      "----------------------------------------------------------------------------------"
    );

    System.out.print("Enter the Book ID: ");
    String bookId = scanner.nextLine();

    boolean bookFound = false;

    for (String[] book : books) {
      if (bookId.equals(book[0])) {
        if (!book[3].equalsIgnoreCase("Available")) {
          boolean ret = false;
          while (!ret) {
            System.out.println("Student ID: " + book[3]);
            System.out.println("Issue Date: " + book[4]);
            long daysDelayed = ChronoUnit.DAYS.between(
              LocalDate.parse(
                book[4],
                DateTimeFormatter.ofPattern("dd-MMM-yyyy")
              ),
              LocalDate.parse(
                getCurrentDate(),
                DateTimeFormatter.ofPattern("dd-MMM-yyyy")
              )
            );
            if (daysDelayed > 7){
              System.out.println("Delayed: " + (daysDelayed-7) + " days");
              int charges = (int) ((daysDelayed-7) * 10);
              System.out.println("Delayed Charges: Rs." + charges);
            }else{
              System.out.println("Delayed: 0 days");

            }
            System.out.print("Enter 'R' to return: ");
            String confirmed = scanner.nextLine();
            if (confirmed.equalsIgnoreCase("R")) {
              book[3] = "Available";
              book[4] = "Null";
              System.out.printf("Book ID: %s Returned back",book[0]);
              ret = true;
            } else {
              System.out.println("Book not returned!!!");
              ret = true;
            }
          }
        } else {
          System.out.println("Book not issued.");
        }
        bookFound = true;
        break;
      }
    }

    if (!bookFound) {
      System.out.println("Book not found!");
    }
  }
}
