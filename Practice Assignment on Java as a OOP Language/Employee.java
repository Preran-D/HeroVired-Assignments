
public class Employee {
    private int empId;
    private String name;
    private String designation;
    private double salary;

    public Employee(int empId, String name, String designation, double salary) {
        this.empId = empId;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public double getSalary() {
        return salary;
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "John Doe", "Manager", 5000);
        Employee employee2 = new Employee(2, "Jane Smith", "Developer", 4000);

        System.out.println("Employee 1 Details:");
        System.out.println("Employee ID: " + employee1.getEmpId());
        System.out.println("Name: " + employee1.getName());
        System.out.println("Designation: " + employee1.getDesignation());
        System.out.println("Salary: " + employee1.getSalary());
        System.out.println();

        System.out.println("Employee 2 Details:");
        System.out.println("Employee ID: " + employee2.getEmpId());
        System.out.println("Name: " + employee2.getName());
        System.out.println("Designation: " + employee2.getDesignation());
        System.out.println("Salary: " + employee2.getSalary());
    }
}
