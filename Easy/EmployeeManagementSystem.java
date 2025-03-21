package Easy;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private ArrayList<Employee> employeeList;
    private Scanner scanner;

    public EmployeeManagementSystem() {
        employeeList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    public void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();
        Employee employee = new Employee(id, name, salary);
        employeeList.add(employee);
        System.out.println("Employee added successfully.");
    }

    public void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            scanner.nextLine();
            System.out.print("Enter new Employee Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new Employee Salary: ");
            double salary = scanner.nextDouble();
            employee.setName(name);
            employee.setSalary(salary);
            System.out.println("Employee details updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }
    public void removeEmployee() {
        System.out.print("Enter Employee ID to remove: ");
        int id = scanner.nextInt();
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            employeeList.remove(employee);
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }
    public void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = scanner.nextInt();
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }
    }
    private Employee findEmployeeById(int id) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
    public void displayAllEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
        }
    }
    public void menu() {
        int choice;
        do {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    removeEmployee();
                    break;
                case 4:
                    searchEmployee();
                    break;
                case 5:
                    displayAllEmployees();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        ems.menu();
    }
}

