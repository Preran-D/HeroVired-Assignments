package SmallClinic;

import java.util.Scanner;

public class AppointmentManagementSystem {

  public static void main(String[] args) {
    Clinic clinic = new Clinic();

    Scanner scanner = new Scanner(System.in);

    int choice;
    do {
      System.out.println("\n--- Small Clinic ---");
      System.out.println("1. View Visitors List");
      System.out.println("2. Add new Visitor");
      System.out.println("3. Edit Visitor Details");
      System.out.println("4. View Appointment Schedule for a Date");
      System.out.println("5. Book an Appointment");
      System.out.println("6. Edit/Cancel Appointment");

      System.out.println("0. Exit");
      System.out.print("Enter your choice: ");
      choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          clinic.viewVisitors();
          break;
        case 2:
          clinic.addVisitor(scanner);
          break;
        case 3:
          clinic.editVisitorDetails(scanner);
          break;
        case 4:
          clinic.viewAppointmentsForDate(scanner);
          break;
        case 5:
          clinic.bookAppointment(scanner);
          break;
        case 6:
          clinic.editCancelAppointment(scanner);
          break;
        case 0:
          System.out.println("Exiting...");
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
          break;
      }
    } while (choice != 0);

    scanner.close();
  }
}
