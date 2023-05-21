import java.util.Scanner;

public class UnitConversion {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            String choice;
            do {
                System.out.println("CM to M - 1");
                System.out.println("M to KM - 2");
                System.out.println("KM to M - 3");
                System.out.println("M to CM - 4");
                System.out.print("Choice 1 to 4: ");
                int option = scan.nextInt();
                scan.nextLine();
                switch (option) {
                    case 1:
                        {
                            System.out.println("Please enter the CM value:");
                            int cm = scan.nextInt();
                            CmToM(cm);
                            break;
                        }
                    case 2:
                        {
                            System.out.println("Please enter the M value:");
                            int meters = scan.nextInt();
                            MToKm(meters);
                            break;
                        }
                    case 3:
                        {
                            System.out.println("Please enter the KM value:");
                            int km = scan.nextInt();
                            KmToM(km);
                            break;
                        }
                    case 4:
                        {
                            System.out.println("Please enter the M value:");
                            int meters = scan.nextInt();
                            MToCm(meters);
                            break;
                        }
                    default:
                        System.out.println("Please enter a valid choice!");
                        break;
                }

                System.out.print("Do you want to continue? (y/n): ");
                choice = scan.next();
            } while (choice.equalsIgnoreCase("y"));
        }
        System.out.println("Program ended.");
    }

    private static void CmToM(int cm) {
        double meters = cm / 100.0;
        System.out.println(cm + " CM = " + meters + " M");
    }

    private static void MToCm(int meters) {
        double cm = meters * 100;
        System.out.println(meters + " M = " + cm + " CM");
    }

    private static void KmToM(int km) {
        double meters = km * 1000.0;
        System.out.println(km + " KM = " + meters + " M");
    }

    private static void MToKm(int meters) {
        double km = meters / 1000.0;
        System.out.println(meters + " M = " + km + " KM");
    }
}
