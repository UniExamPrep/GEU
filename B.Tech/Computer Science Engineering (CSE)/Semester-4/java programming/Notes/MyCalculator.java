import java.util.Scanner;

class MyCalculator {
    // Method to calculate n^p with exception handling
    public long power(int n, int p) throws Exception {
        // Check if either n or p is negative
        if (n < 0 || p < 0) {
            throw new Exception("n or p should not be negative.");
        }
        
        // Check if both n and p are zero
        if (n == 0 && p == 0) {
            throw new Exception("n and p should not be zero.");
        }
        
        // Calculate n^p
        long result = 1;
        for (int i = 0; i < p; i++) {
            result *= n;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyCalculator calculator = new MyCalculator();
        
        System.out.println("Power Calculator");
        System.out.println("---------------");
        
        // Process multiple inputs
        System.out.println("Enter input pairs (n p) one per line. Type 'exit' to quit:");
        
        while (true) {
            System.out.print("\nEnter n and p (or 'exit'): ");
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            
            try {
                String[] parts = input.split("\\s+");
                
                if (parts.length != 2) {
                    System.out.println("Please enter two integers separated by space.");
                    continue;
                }
                
                int n = Integer.parseInt(parts[0]);
                int p = Integer.parseInt(parts[1]);
                
                long result = calculator.power(n, p);
                System.out.println(result);
                
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid integers.");
            } catch (Exception e) {
                System.out.println(e.getClass().getName() + ": " + e.getMessage());
            }
        }
        
        scanner.close();
    }
} 