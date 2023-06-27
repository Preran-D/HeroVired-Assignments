package SmallClinic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Clinic {

  private List<Visitor> visitors;
  private Map<String, Map<String, Visitor>> appointments;

  public Clinic() {
    visitors = new ArrayList<>();
    appointments = new HashMap<>();
  }

  public void editCancelAppointment(Scanner scanner) {
    System.out.print("Enter visitor's name: ");
    String visitorName = scanner.nextLine();
    int visitorIndex = visitorIndex(visitorName);
    if (visitorIndex >= 0) {
      System.out.print("Enter appointment date (dd-mm-yyyy): ");
      String date = scanner.nextLine();

      if (appointments.containsKey(date)) {
        System.out.print("Enter appointment time (8 - 17 in 24hr format): ");
        String time = scanner.nextLine();

        Map<String, Visitor> appointmentList = appointments.get(date);
        if (appointmentList.containsKey(time)) {
          Visitor visitor = appointmentList.get(time);

          System.out.println("Visitor: " + visitor.getName());
          System.out.println("1. Edit appointment timings");
          System.out.println("2. For Cancelling or Visit is done.");
          System.out.println("0. Go back");
          System.out.print("Enter your choice: ");
          int choice = scanner.nextInt();
          scanner.nextLine();

          switch (choice) {
            case 1:
              System.out.print(
                "Enter new appointment time 9am - 5pm in (24hr format): "
              );
              String newTime = scanner.nextLine();

              if (
                Integer.parseInt(newTime) >= 9 &&
                Integer.parseInt(newTime) <= 17
              ) {
                appointmentList.remove(time);
                appointmentList.put(newTime, visitor);
                System.out.println("Appointment edited successfully.");
              } else {
                System.out.println(
                  "Invalid time. Please enter a time between 9am - 5pm in (24hr format) ."
                );
              }
              break;
            case 2:
              appointmentList.remove(time);
              System.out.println("Appointment canceled successfully.");
              break;
            case 0:
              System.out.println("Going back to the main menu.");
              break;
            default:
              System.out.println("Invalid choice. Please try again.");
              break;
          }
        } else {
          System.out.println("No appointment found for the specified time.");
        }
      } else {
        System.out.println("No appointments scheduled for the specified date.");
      }
    } else {
      System.out.println("Visitor not found.");
    }
  }

  public void viewAppointmentsForDate(Scanner scanner) {
    System.out.print("Enter date to view appointments (dd-mm-yyyy): ");
    String date = scanner.nextLine();

    if (appointments.containsKey(date)) {
      System.out.println("Appointments for " + date + ":");
      Map<String, Visitor> appointmentList = appointments.get(date);
      if (!appointmentList.isEmpty()) {
        for (String time : appointmentList.keySet()) {
          Visitor visitor = appointmentList.get(time);
          System.out.println(
            "Time: " + time + " -> Visitor: " + visitor.getName()
          );
        }
      } else {
        System.out.println("No appointments scheduled for the specified date.");
      }
    } else {
      System.out.println("No appointments scheduled for the specified date.");
    }
  }

  public void addVisitor(Scanner scanner) {
    System.out.print("Enter Visitor Name: ");
    String name = scanner.nextLine();

    System.out.print("Enter Contact Number: ");
    String number = scanner.nextLine();

    Visitor visitor = new Visitor(name.trim().toUpperCase(), number.trim());
    visitors.add(visitor);
    System.out.println("Visitor added successfully.");
  }

  public void viewVisitors() {
    if (!visitors.isEmpty()) {
      for (int i = 0; i < visitors.size(); i++) {
        System.out.println(
          "Visitor " +
          (i + 1) +
          ": " +
          visitors.get(i).getName() +
          " -> Contact Number: " +
          visitors.get(i).getContactNumber()
        );
      }
    } else {
      System.out.println("No visitors added.");
    }
  }

  public void editVisitorDetails(Scanner scanner) {
    System.out.print("Enter visitor's name: ");
    String name = scanner.nextLine();
    int index = visitorIndex(name);
    if (index >= 0) {
      System.out.print("Enter new name: ");
      String newName = scanner.nextLine().trim();
      visitors.get(index).setName(newName);

      System.out.print("Enter new contact number: ");
      String newNumber = scanner.nextLine().trim();
      visitors.get(index).setContactNumber(newNumber);

      System.out.println("Visitor details updated successfully.");
    } else {
      System.out.println("Visitor not found.");
    }
  }

  public int visitorIndex(String name) {
    for (int i = 0; i < visitors.size(); i++) {
      if (visitors.get(i).getName().equalsIgnoreCase(name)) {
        return i;
      }
    }
    return -1;
  }

  public void bookAppointment(Scanner scanner) {
    System.out.print("Enter visitor's name: ");
    String visitorName = scanner.nextLine();
    int visitorIndex = visitorIndex(visitorName);
    if (visitorIndex >= 0) {
      System.out.print("Enter appointment date (dd-mm-yyyy): ");
      String date = scanner.nextLine();

      System.out.print("Enter appointment time (9am - 5pm in 24hr format): ");
      String time = scanner.nextLine();

      if (appointments.containsKey(date)) {
        Map<String, Visitor> appointmentList = appointments.get(date);
        if (appointmentList.containsKey(time)) {
          System.out.println("The selected time slot is already booked.");
          return;
        }
      } else {
        appointments.put(date, new HashMap<>());
      }

      if (Integer.parseInt(time) >= 9 && Integer.parseInt(time) <= 17) {
        appointments.get(date).put(time, visitors.get(visitorIndex));
        System.out.println("Appointment booked successfully.");
      } else {
        System.out.println(
          "Invalid time. Please enter a time between 9am - 5pm in 24hr format."
        );
      }
    } else {
      System.out.println("Visitor not found.");
    }
  }
}
