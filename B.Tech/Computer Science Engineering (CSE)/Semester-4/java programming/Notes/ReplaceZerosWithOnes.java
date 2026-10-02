import java.util.Scanner;

public class ReplaceZerosWithOnes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Replace 0's with 1's");
        System.out.println("-------------------");
        
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        
        int result = replaceZerosWithOnes(number);
        
        System.out.println("Input: " + number);
        System.out.println("Output: " + result);
        
        scanner.close();
    }
    
    private static int replaceZerosWithOnes(int number) {
        // If number is 0, return 1
        if (number == 0) {
            return 1;
        }
        
        // For handling negative numbers
        boolean isNegative = false;
        if (number < 0) {
            isNegative = true;
            number = -number;
        }
        
        // Convert to string, replace zeros, and convert back to int
        String numberStr = Integer.toString(number);
        numberStr = numberStr.replace('0', '1');
        int result = Integer.parseInt(numberStr);
        
        // Return result with original sign
        return isNegative ? -result : result;
    }
} 