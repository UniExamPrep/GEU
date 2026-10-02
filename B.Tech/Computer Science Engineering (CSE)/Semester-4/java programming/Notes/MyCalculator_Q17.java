/*
17. Create a class MyCalculator which consists of a single method power (int, int). This method takes two integers, n and p, as parameters and finds np. If either n or p is negative, then the method must throw an exception which says, "n and p should be non- negative".

Input Format
Each line of the input contains two integers, n and p. Output Format
Each line of the output contains the result, if neither of n and p is negative.

Otherwise, the output contains "n and p should be non- negative".

Sample Input
3 5
2 4
0 0
-1 -2
-1 3
Sample Output
243
16
java.lang.Exception: n and p should not be zero. java.lang.Exception: n or p should not be negative. java. lang. Exception: n or p should not be negative.


Explanation
In the first two cases, both n and p are positive. So, the power function returns the answer correctly.

In the third case, both n and p are zero. So, the exception, "n and p should not be zero." is printed.

In the last two cases, at least one out of n and p is negative. So, the exception, "n or p should not be negative." is printed for these two cases.
*/

import java.util.Scanner;

class MyCalculator_Q17 {
    // Method to calculate power with exception handling
    public long power_Q17(int n, int p) throws Exception {
        // Check if both n and p are zero
        if (n == 0 && p == 0) {
            throw new Exception("n and p should not be zero.");
        }
        
        // Check if either n or p is negative
        if (n < 0 || p < 0) {
            throw new Exception("n or p should not be negative.");
        }
        
        // Calculate n^p
        return (long) Math.pow(n, p);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyCalculator_Q17 calculator = new MyCalculator_Q17();
        
        System.out.println("Enter pairs of integers (n p) to calculate n^p:");
        System.out.println("Enter 'exit' to quit");
        
        while (scanner.hasNext()) {
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            
            try {
                String[] values = input.split("\\s+");
                
                if (values.length != 2) {
                    System.out.println("Please enter two integers separated by space.");
                    continue;
                }
                
                int n = Integer.parseInt(values[0]);
                int p = Integer.parseInt(values[1]);
                
                long result = calculator.power_Q17(n, p);
                System.out.println(result);
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter integers only.");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        scanner.close();
    }
} 