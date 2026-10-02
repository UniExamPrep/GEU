/*
4. Program to replace all 0's with 1 in a given integer. Given an integer as an input, all the 0's in the number has to be replaced with 1.
For example, consider the following number Input: 102405
Output: 112415
Input: 56004
Output: 56114
Steps to replace all 0's with 1 in a given integer

• Input the integer from the user.
• Traverse the integer digit by digit.
• If a '0' is encountered, replace it by '1'.
• Print the integer.
*/

import java.util.Scanner;

public class ReplaceZerosWithOnes_Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input the integer
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        
        // Replace 0's with 1's
        int result = replaceZerosWithOnes_Q4(number);
        
        // Display the result
        System.out.println("After replacing 0's with 1's: " + result);
        
        scanner.close();
    }
    
    // Method to replace all 0's with 1's in a number
    private static int replaceZerosWithOnes_Q4(int num) {
        // If number is 0, return 1
        if (num == 0) {
            return 1;
        }
        
        // For handling negative numbers
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num = -num;
        }
        
        // Convert to string for easier digit manipulation
        String numStr = Integer.toString(num);
        StringBuilder result = new StringBuilder();
        
        // Replace each '0' with '1'
        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) == '0') {
                result.append('1');
            } else {
                result.append(numStr.charAt(i));
            }
        }
        
        // Convert back to integer
        int replacedNum = Integer.parseInt(result.toString());
        
        // Return with original sign
        return isNegative ? -replacedNum : replacedNum;
    }
} 