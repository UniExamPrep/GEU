/*
3. Program to find if the given numbers are Friendly pair or not (Amicable or not). Friendly Pair are two or more numbers with a common abundance.
Input & Output format:

• Input consists of 2 integers.
• The first integer corresponds to number 1 and the second integer corresponds to number 2.
If it is a Friendly Pair display Friendly Pair or displays Not Friendly Pair.

For example,6 and 28 are Friendly Pair.
(Sum of divisors of 6)/6 = (Sum of divisors of 28)/28.
Steps to check whether the given numbers are friendly pair or not

Input the numbers num1 and num2.
Initialize sum1 = sum2 = 0.
sum1 = sum of all divisors of num1.
sum2 = sum of all divisors of num2.
If (sum1 == num1) and (sum2 == num2), then print "Abundant Numbers".
Else, print "Not Abundant Numbers".
*/

import java.util.Scanner;

public class FriendlyPair_Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input two numbers
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        
        // Check if they are friendly pair
        if (isFriendlyPair_Q3(num1, num2)) {
            System.out.println("Friendly Pair");
        } else {
            System.out.println("Not Friendly Pair");
        }
        
        scanner.close();
    }
    
    // Function to find sum of divisors of a number
    private static int sumOfDivisors_Q3(int num) {
        int sum = 0;
        
        // Find all divisors and add them
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        
        return sum;
    }
    
    // Function to check if two numbers are friendly pair
    private static boolean isFriendlyPair_Q3(int num1, int num2) {
        // Calculate sum of divisors for both numbers
        int sum1 = sumOfDivisors_Q3(num1);
        int sum2 = sumOfDivisors_Q3(num2);
        
        // Calculate abundance for both numbers
        double abundance1 = (double) sum1 / num1;
        double abundance2 = (double) sum2 / num2;
        
        // Check if abundances are equal
        return abundance1 == abundance2;
    }
} 