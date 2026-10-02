/*
13. Method overriding (Runtime Polymorphism), Abstract class and Abstract method, Inheritance, interfaces:
Write a java program to calculate the area of a rectangle, a square and a circle. Create an abstract class 'Shape' with three abstract methods namely rectangleArea() taking two parameters, squareArea() and circleArea() taking one parameter each.
Now create another class 'Area' containing all the three methods rectangleArea(), squareArea() and circleArea() for printing the area of rectangle, square and circle respectively. Create an object of class Area and call all the three methods.
(Use Runtime Polymorphism)
*/

abstract class Shape_Q13 {
    // Abstract methods
    abstract double rectangleArea_Q13(double length, double width);
    abstract double squareArea_Q13(double side);
    abstract double circleArea_Q13(double radius);
}

class Area_Q13 extends Shape_Q13 {
    // Implementation of rectangleArea method
    @Override
    double rectangleArea_Q13(double length, double width) {
        return length * width;
    }
    
    // Implementation of squareArea method
    @Override
    double squareArea_Q13(double side) {
        return side * side;
    }
    
    // Implementation of circleArea method
    @Override
    double circleArea_Q13(double radius) {
        return Math.PI * radius * radius;
    }
}

public class ShapeArea_Q13 {
    public static void main(String[] args) {
        // Create an object of Area class
        Shape_Q13 shape = new Area_Q13(); // Using runtime polymorphism
        
        // Calculate and display area of rectangle
        double rectangleLength = 5.0;
        double rectangleWidth = 3.0;
        System.out.println("Rectangle with length = " + rectangleLength + 
                           " and width = " + rectangleWidth);
        System.out.println("Area of Rectangle: " + 
                           shape.rectangleArea_Q13(rectangleLength, rectangleWidth));
        
        // Calculate and display area of square
        double squareSide = 4.0;
        System.out.println("\nSquare with side = " + squareSide);
        System.out.println("Area of Square: " + shape.squareArea_Q13(squareSide));
        
        // Calculate and display area of circle
        double circleRadius = 2.5;
        System.out.println("\nCircle with radius = " + circleRadius);
        System.out.println("Area of Circle: " + shape.circleArea_Q13(circleRadius));
    }
} 