/*
8. String Handling in Java (using String and StringBuffer class):
Program to find all the patterns of 0(1+)0 in the given string. Given a string containing 0's and 1's, find the total number of 0(1+)0 patterns in the string and output it.
0(1+)0 - There should be at least one '1' between the two 0's.
For example, consider the following string.
Input: 01101111010
Output: 3
Explanation: 01101111010 - count = 1
*/

import java.util.Scanner;

public class PatternFinding_Q8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input the binary string
        System.out.print("Enter a binary string (containing only 0's and 1's): ");
        String binaryString = scanner.nextLine();
        
        // Count patterns of 0(1+)0
        int patternCount = countPatterns_Q8(binaryString);
        
        // Display the result
        System.out.println("Number of 0(1+)0 patterns: " + patternCount);
        
        scanner.close();
    }
    
    // Function to count patterns of 0(1+)0 in a string
    private static int countPatterns_Q8(String str) {
        int count = 0;
        
        // Traverse the string
        for (int i = 0; i < str.length() - 2; i++) {
            // Check if current character is '0'
            if (str.charAt(i) == '0') {
                // Find the next occurrence of '0' after at least one '1'
                int j = i + 1;
                boolean foundOne = false;
                
                while (j < str.length()) {
                    if (str.charAt(j) == '1') {
                        foundOne = true;
                    } else if (str.charAt(j) == '0' && foundOne) {
                        // Found a pattern 0(1+)0
                        count++;
                        break;
                    }
                    j++;
                }
            }
        }
        
        return count;
    }
} 