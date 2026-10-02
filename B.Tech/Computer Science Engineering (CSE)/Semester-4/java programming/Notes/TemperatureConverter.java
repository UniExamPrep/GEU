import java.util.Scanner;

// Abstract class Temperature
abstract class Temperature {
    protected double temp;
    
    // Method to set temperature data
    public void setTempData(double temp) {
        this.temp = temp;
    }
    
    // Abstract method to be implemented by subclasses
    abstract void changeTemp();
}

// Fahrenheit class to convert to Celsius
class Fahrenheit extends Temperature {
    private double ctemp; // Celsius temperature
    
    @Override
    void changeTemp() {
        // Convert Fahrenheit to Celsius: C = 5/9 * (F - 32)
        ctemp = 5.0 / 9.0 * (temp - 32);
        System.out.printf("%.2f°F = %.2f°C\n", temp, ctemp);
    }
}

// Celsius class to convert to Fahrenheit
class Celsius extends Temperature {
    private double ftemp; // Fahrenheit temperature
    
    @Override
    void changeTemp() {
        // Convert Celsius to Fahrenheit: F = 9/5 * C + 32
        ftemp = 9.0 / 5.0 * temp + 32;
        System.out.printf("%.2f°C = %.2f°F\n", temp, ftemp);
    }
}

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Temperature Converter");
        System.out.println("--------------------");
        
        // Create Fahrenheit to Celsius converter
        Fahrenheit fahrenheit = new Fahrenheit();
        System.out.print("Enter temperature in Fahrenheit: ");
        double fTemp = scanner.nextDouble();
        fahrenheit.setTempData(fTemp);
        fahrenheit.changeTemp();
        
        // Create Celsius to Fahrenheit converter
        Celsius celsius = new Celsius();
        System.out.print("Enter temperature in Celsius: ");
        double cTemp = scanner.nextDouble();
        celsius.setTempData(cTemp);
        celsius.changeTemp();
        
        scanner.close();
    }
} 