import java.util.Scanner;

// Custom exceptions
class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }
}

class InvalidEmployeeIdException extends Exception {
    public InvalidEmployeeIdException(String message) {
        super(message);
    }
}

class InvalidDepartmentIdException extends Exception {
    public InvalidDepartmentIdException(String message) {
        super(message);
    }
}

class Employee {
    private String name;
    private int empId;
    private int deptId;
    
    // Constructor with validation
    public Employee(String name, int empId, int deptId) throws InvalidNameException, InvalidEmployeeIdException, InvalidDepartmentIdException {
        // Validate name - first letter should be uppercase
        if (name == null || name.isEmpty() || !Character.isUpperCase(name.charAt(0))) {
            throw new InvalidNameException("First letter of employee name should be in capital letter.");
        }
        
        // Validate employee id - should be between 2001 and 5001
        if (empId < 2001 || empId > 5001) {
            throw new InvalidEmployeeIdException("Employee ID should be between 2001 and 5001.");
        }
        
        // Validate department id - should be between 1 and 5
        if (deptId < 1 || deptId > 5) {
            throw new InvalidDepartmentIdException("Department ID should be an integer between 1 and 5.");
        }
        
        this.name = name;
        this.empId = empId;
        this.deptId = deptId;
    }
    
    // Display employee details
    public void displayDetails() {
        System.out.println("\nEmployee Details:");
        System.out.println("-----------------");
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + empId);
        System.out.println("Department ID: " + deptId);
    }
}

public class EmployeeValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Employee Details Validator");
        System.out.println("-------------------------");
        
        try {
            // Get employee name
            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();
            
            // Get employee id
            System.out.print("Enter employee ID (2001-5001): ");
            int empId = scanner.nextInt();
            
            // Get department id
            System.out.print("Enter department ID (1-5): ");
            int deptId = scanner.nextInt();
            
            // Create employee object with validation
            Employee employee = new Employee(name, empId, deptId);
            
            // Display employee details
            employee.displayDetails();
            
        } catch (InvalidNameException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InvalidEmployeeIdException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InvalidDepartmentIdException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Incomplete or incorrect data. " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
} 