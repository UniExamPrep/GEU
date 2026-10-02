import java.util.Scanner;

// Interface for Volume calculation
interface Volume {
    // Abstract method to calculate volume
    double volume();
    
    // Method to display volume
    default void displayVolume() {
        System.out.printf("Volume: %.2f cubic units\n", volume());
    }
}

// Cone class implementing Volume
class Cone implements Volume {
    private double radius;
    private double height;
    
    // Constructor
    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
    
    @Override
    public double volume() {
        // Volume of cone = (1/3) * π * r² * h
        return (1.0/3.0) * Math.PI * radius * radius * height;
    }
}

// Hemisphere class implementing Volume
class Hemisphere implements Volume {
    private double radius;
    
    // Constructor
    public Hemisphere(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double volume() {
        // Volume of hemisphere = (2/3) * π * r³
        return (2.0/3.0) * Math.PI * Math.pow(radius, 3);
    }
}

// Cylinder class implementing Volume
class Cylinder implements Volume {
    private double radius;
    private double height;
    
    // Constructor
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
    
    @Override
    public double volume() {
        // Volume of cylinder = π * r² * h
        return Math.PI * radius * radius * height;
    }
}

public class VolumeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Volume Calculator");
        System.out.println("----------------");
        
        // Menu for selecting shape
        int choice;
        do {
            System.out.println("\nSelect a shape to calculate volume:");
            System.out.println("1. Cone");
            System.out.println("2. Hemisphere");
            System.out.println("3. Cylinder");
            System.out.println("4. Exit");
            
            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("\nCone Volume Calculation");
                    System.out.println("----------------------");
                    
                    System.out.print("Enter radius: ");
                    double coneRadius = scanner.nextDouble();
                    
                    System.out.print("Enter height: ");
                    double coneHeight = scanner.nextDouble();
                    
                    Cone cone = new Cone(coneRadius, coneHeight);
                    cone.displayVolume();
                    break;
                    
                case 2:
                    System.out.println("\nHemisphere Volume Calculation");
                    System.out.println("---------------------------");
                    
                    System.out.print("Enter radius: ");
                    double hemisphereRadius = scanner.nextDouble();
                    
                    Hemisphere hemisphere = new Hemisphere(hemisphereRadius);
                    hemisphere.displayVolume();
                    break;
                    
                case 3:
                    System.out.println("\nCylinder Volume Calculation");
                    System.out.println("-------------------------");
                    
                    System.out.print("Enter radius: ");
                    double cylinderRadius = scanner.nextDouble();
                    
                    System.out.print("Enter height: ");
                    double cylinderHeight = scanner.nextDouble();
                    
                    Cylinder cylinder = new Cylinder(cylinderRadius, cylinderHeight);
                    cylinder.displayVolume();
                    break;
                    
                case 4:
                    System.out.println("Exiting...");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        
        scanner.close();
    }
} 