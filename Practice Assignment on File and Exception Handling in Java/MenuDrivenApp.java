import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MenuDrivenApp {

  public static void main(String[] args) throws IOException {
    boolean exit = false;

    while (!exit) {
      System.out.println(
        "1. Create a new folder \n2. Create a new text file \n3. Write into a text file \n4. Append data to a text file \n5. Rename a file \n6. Delete a File"
      );
      System.out.println("Please enter the Menu: ");
      Scanner scanner = new Scanner(System.in);
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          createNewFolder(scanner);
          break;
        case 2:
          createNewTextFile(scanner);
          break;
        case 3:
          writeToFile(scanner);
          break;
        case 4:
          appendToFile(scanner);
          break;
        case 5:
          renameFile(scanner);
          break;
        case 6:
          deleteFile(scanner);
          break;
        default:
          System.out.println("Invalid choice!");
      }
      if (!exit) {
        System.out.println(
          "Press 'Y' to go back to the Main File-Operations Menu: "
        );
      }
      String continueChoice = scanner.nextLine();
      if (continueChoice.equalsIgnoreCase("N")) {
        exit = true;
      }
    }
  }

  public static void createNewFolder(Scanner scanner) {
    System.out.println("Please enter the folder name to be created: ");
    String textFileName = scanner.nextLine();
    System.out.println(
      "Please enter the Path where you wish to save a new folder: "
    );
    String path = scanner.nextLine();
    File textFile = new File(path, textFileName);

    if (!textFile.isAbsolute()) {
      System.out.println("Invalid absolute path entered.");
      return;
    }

    try {
      textFile.createNewFile();
      System.out.println("Text file " + textFileName + " is created");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void createNewTextFile(Scanner scanner) {
    System.out.println("Please enter the text file name to be created: ");
    String textFileName = scanner.nextLine();
    System.out.println(
      "Please enter the Path where you wish to save the file: "
    );
    String path = scanner.nextLine();
    File file = new File(path, textFileName + ".txt");

    if (!file.isAbsolute()) {
      System.out.println("Invalid absolute path entered.");
      return;
    }

    try {
      boolean success = file.createNewFile();
      if (success) {
        System.out.println(
          "Text file " + textFileName + " created successfully in " + path
        );
      } else {
        System.out.println("Failed to create text file " + textFileName);
      }
    } catch (IOException e) {
      System.out.println("System cannot find path.");
    }
  }

  public static void writeToFile(Scanner scanner) {
    try {
      System.out.println("Enter the text file name with path: ");
      String fileName = scanner.nextLine();
      BufferedWriter wr = new BufferedWriter(new FileWriter(fileName));
      System.out.println("Enter the text to write into the file: ");
      String text = scanner.nextLine();
      wr.write(text);
      
      wr.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void appendToFile(Scanner scanner) {
    try {
        System.out.println("Enter the text file name with path and extension: ");
        String fileName = scanner.nextLine();
        BufferedWriter wr = new BufferedWriter(new FileWriter(fileName,true));
        System.out.println("Enter the text to append into the file: ");
        String text = scanner.nextLine();
      wr.newLine(); 

        wr.write(text);
        
        wr.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
  }

  public static void renameFile(Scanner scanner) throws IOException {
    System.out.println("Enter the path: ");
    String path = scanner.nextLine();
    System.out.println("Enter the file name with extenstion: ");
    String fileName = scanner.nextLine();
    System.out.println("Enter the file name to rename with extenstion: ");
    String newFileName = scanner.nextLine();

    File oldFile = new File(path, fileName);
    File newFile = new File(path, newFileName);


    boolean flag = oldFile.renameTo(newFile);
  
        if (flag == true) {
            System.out.println("File Successfully Renamed");
        }
        
        else {
            System.out.println("Operation Failed");
        }
  }

  public static void deleteFile(Scanner scanner) {
    System.out.println("Enter the file name with path and extension: ");
    String fileName = scanner.nextLine();
      File file = new File(fileName);
      file.delete();

      if (file.delete()) {
        System.out.println("File deleted successfully: " + fileName);
    } else {
        System.out.println("Failed to delete file: " + fileName);
    }
  }
}
