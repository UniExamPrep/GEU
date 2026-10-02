/*
15. Write a java program to create an interface that consists of a method to display volume () as an abstract method and redefine this method in the derived classes to suit their requirements.
Create classes called Cone, Hemisphere and Cylinder that implements the interface. Using these three classes, design a program that will accept dimensions of a cone, cylinder and hemisphere interactively and display the volumes.

Volume of cone = (1/3)πr2h Volume of hemisphere = (2/3)πr3 Volume of cylinder = πr2h
*/

import java.util.Scanner;

// Interface for volume calculation
interface Volume_Q15 {
    // Abstract method to display volume
    void displayVolume_Q15();
}

// Cone class implementing Volume interface
class Cone_Q15 implements Volume_Q15 {
    private double radius;
    private double height;
    
    // Constructor
    public Cone_Q15(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
    
    // Implementation of displayVolume method
    @Override
    public void displayVolume_Q15() {
        double volume = (1.0 / 3.0) * Math.PI * radius * radius * height;
        System.out.printf("Volume of Cone: %.2f cubic units\n", volume);
    }
}

// Hemisphere class implementing Volume interface
class Hemisphere_Q15 implements Volume_Q15 {
    private double radius;
    
    // Constructor
    public Hemisphere_Q15(double radius) {
        this.radius = radius;
    }
    
    // Implementation of displayVolume method
    @Override
    public void displayVolume_Q15() {
        double volume = (2.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        System.out.printf("Volume of Hemisphere: %.2f cubic units\n", volume);
    }
}

// Cylinder class implementing Volume interface
class Cylinder_Q15 implements Volume_Q15 {
    private double radius;
    private double height;
    
    // Constructor
    public Cylinder_Q15(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
    
    // Implementation of displayVolume method
    @Override
    public void displayVolume_Q15() {
        double volume = Math.PI * radius * radius * height;
        System.out.printf("Volume of Cylinder: %.2f cubic units\n", volume);
    }
}

public class VolumeCalculator_Q15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Menu for volume calculation
        int choice;
        do {
            System.out.println("\nVolume Calculator Menu:");
            System.out.println("1. Calculate volume of Cone");
            System.out.println("2. Calculate volume of Hemisphere");
            System.out.println("3. Calculate volume of Cylinder");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter radius of cone: ");
                    double coneRadius = scanner.nextDouble();
                    System.out.print("Enter height of cone: ");
                    double coneHeight = scanner.nextDouble();
                    
                    Volume_Q15 cone = new Cone_Q15(coneRadius, coneHeight);
                    cone.displayVolume_Q15();
                    break;
                    
                case 2:
                    System.out.print("Enter radius of hemisphere: ");
                    double hemisphereRadius = scanner.nextDouble();
                    
                    Volume_Q15 hemisphere = new Hemisphere_Q15(hemisphereRadius);
                    hemisphere.displayVolume_Q15();
                    break;
                    
                case 3:
                    System.out.print("Enter radius of cylinder: ");
                    double cylinderRadius = scanner.nextDouble();
                    System.out.print("Enter height of cylinder: ");
                    double cylinderHeight = scanner.nextDouble();
                    
                    Volume_Q15 cylinder = new Cylinder_Q15(cylinderRadius, cylinderHeight);
                    cylinder.displayVolume_Q15();
                    break;
                    
                case 4:
                    System.out.println("Exiting program...");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        
        scanner.close();
    }
} 