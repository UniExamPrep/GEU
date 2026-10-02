/*
9. Write a java program to delete vowels from given string using StringBuffer class
*/

import java.util.Scanner;

public class DeleteVowels_Q9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input the string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        
        // Delete vowels from the string
        String result = deleteVowels_Q9(inputString);
        
        // Display the result
        System.out.println("String after removing vowels: " + result);
        
        scanner.close();
    }
    
    // Function to delete vowels from a string using StringBuffer
    private static String deleteVowels_Q9(String str) {
        // Convert the string to StringBuffer for efficient modification
        StringBuffer sb = new StringBuffer(str);
        
        // Traverse the StringBuffer from end to start
        // (to avoid index shifting when deleting characters)
        for (int i = sb.length() - 1; i >= 0; i--) {
            char ch = Character.toLowerCase(sb.charAt(i));
            
            // Check if the character is a vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                // Delete the vowel
                sb.deleteCharAt(i);
            }
        }
        
        // Convert StringBuffer back to String and return
        return sb.toString();
    }
} 