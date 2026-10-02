import java.util.Scanner;

// Abstract class Shape
abstract class Shape {
    // Abstract methods for area calculations
    abstract double rectangleArea(double length, double width);
    abstract double squareArea(double side);
    abstract double circleArea(double radius);
}

// Area class implementing the abstract methods
class Area extends Shape {
    @Override
    double rectangleArea(double length, double width) {
        return length * width;
    }
    
    @Override
    double squareArea(double side) {
        return side * side;
    }
    
    @Override
    double circleArea(double radius) {
        return Math.PI * radius * radius;
    }
}

public class ShapeArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Area Calculator");
        System.out.println("--------------");
        
        // Create an instance of Area
        Area area = new Area();
        
        // Calculate rectangle area
        System.out.println("\nCalculate Rectangle Area:");
        System.out.print("Enter length: ");
        double length = scanner.nextDouble();
        
        System.out.print("Enter width: ");
        double width = scanner.nextDouble();
        
        System.out.printf("Area of rectangle: %.2f\n", area.rectangleArea(length, width));
        
        // Calculate square area
        System.out.println("\nCalculate Square Area:");
        System.out.print("Enter side length: ");
        double side = scanner.nextDouble();
        
        System.out.printf("Area of square: %.2f\n", area.squareArea(side));
        
        // Calculate circle area
        System.out.println("\nCalculate Circle Area:");
        System.out.print("Enter radius: ");
        double radius = scanner.nextDouble();
        
        System.out.printf("Area of circle: %.2f\n", area.circleArea(radius));
        
        scanner.close();
    }
} 