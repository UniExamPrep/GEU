/*
16. Write a java program to accept and print the employee details during runtime. The details will include employee id, name, dept_ Id. The program should raise an exception if user inputs incomplete or incorrect data. The entered value should meet the following conditions:

a. First Letter of employee name should be in capital letter.
b. Employee id should be between 2001 and 5001
c. Department id should be an integer between 1 and 5.

If the above conditions are not met, then the application should raise specific exception else should complete normal execution.
*/

import java.util.Scanner;

// Custom exception for invalid employee name
class InvalidEmployeeNameException_Q16 extends Exception {
    public InvalidEmployeeNameException_Q16(String message) {
        super(message);
    }
}

// Custom exception for invalid employee ID
class InvalidEmployeeIdException_Q16 extends Exception {
    public InvalidEmployeeIdException_Q16(String message) {
        super(message);
    }
}

// Custom exception for invalid department ID
class InvalidDepartmentIdException_Q16 extends Exception {
    public InvalidDepartmentIdException_Q16(String message) {
        super(message);
    }
}

class Employee_Q16 {
    private int employeeId;
    private String name;
    private int departmentId;
    
    // Constructor
    public Employee_Q16(int employeeId, String name, int departmentId) 
            throws InvalidEmployeeIdException_Q16, InvalidEmployeeNameException_Q16, InvalidDepartmentIdException_Q16 {
        
        // Validate employee ID
        if (employeeId < 2001 || employeeId > 5001) {
            throw new InvalidEmployeeIdException_Q16("Employee ID must be between 2001 and 5001");
        }
        
        // Validate employee name
        if (name == null || name.isEmpty() || !Character.isUpperCase(name.charAt(0))) {
            throw new InvalidEmployeeNameException_Q16("First letter of employee name must be in capital letter");
        }
        
        // Validate department ID
        if (departmentId < 1 || departmentId > 5) {
            throw new InvalidDepartmentIdException_Q16("Department ID must be between 1 and 5");
        }
        
        // If all validations pass, set the values
        this.employeeId = employeeId;
        this.name = name;
        this.departmentId = departmentId;
    }
    
    // Method to display employee details
    public void displayDetails_Q16() {
        System.out.println("\nEmployee Details:");
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department ID: " + departmentId);
    }
}

public class EmployeeDetailsValidator_Q16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Input employee details
            System.out.println("Enter Employee Details:");
            
            System.out.print("Employee ID (2001-5001): ");
            int empId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            System.out.print("Employee Name (First letter should be capital): ");
            String empName = scanner.nextLine();
            
            System.out.print("Department ID (1-5): ");
            int deptId = scanner.nextInt();
            
            // Create employee object with validation
            Employee_Q16 employee = new Employee_Q16(empId, empName, deptId);
            
            // Display employee details if all validations pass
            System.out.println("\nValidation successful!");
            employee.displayDetails_Q16();
            
        } catch (InvalidEmployeeIdException_Q16 e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InvalidEmployeeNameException_Q16 e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InvalidDepartmentIdException_Q16 e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please check your input format.");
        } finally {
            scanner.close();
        }
    }
} 