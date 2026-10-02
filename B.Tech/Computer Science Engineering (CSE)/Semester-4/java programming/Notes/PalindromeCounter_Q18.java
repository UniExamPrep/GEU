/*
18. File Handling in Java:
Write a java file handling program to count and display the number of palindromes present in a text file "myfile.txt".
Example: If the file "myfile.txt" contains the following lines,
My name is NITIN
Hello aaa and bbb word How are You
ARORA is my friend Output will be => 4
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class PalindromeCounter_Q18 {
    public static void main(String[] args) {
        // First, let's create the sample file
        createSampleFile_Q18();
        
        try {
            // Open the file for reading
            FileReader fileReader = new FileReader("myfile.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line;
            int palindromeCount = 0;
            
            System.out.println("Palindromes found in the file:");
            
            // Read the file line by line
            while ((line = bufferedReader.readLine()) != null) {
                // Tokenize the line to get individual words
                StringTokenizer tokenizer = new StringTokenizer(line, " \t\n\r\f,.:;?!\"'()[]{}");
                
                while (tokenizer.hasMoreTokens()) {
                    String word = tokenizer.nextToken();
                    
                    // Check if the word is a palindrome
                    if (isPalindrome_Q18(word) && word.length() > 1) {
                        System.out.println(word);
                        palindromeCount++;
                    }
                }
            }
            
            // Close the file
            bufferedReader.close();
            
            // Display the total count of palindromes
            System.out.println("\nTotal number of palindromes: " + palindromeCount);
            
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
    
    // Method to check if a string is a palindrome
    private static boolean isPalindrome_Q18(String str) {
        // Convert to lowercase for case-insensitive comparison
        str = str.toLowerCase();
        
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    // Method to create a sample file for testing
    private static void createSampleFile_Q18() {
        try {
            FileWriter writer = new FileWriter("myfile.txt");
            writer.write("My name is NITIN\n");
            writer.write("Hello aaa and bbb word How are You\n");
            writer.write("ARORA is my friend\n");
            writer.close();
            System.out.println("Sample file 'myfile.txt' created successfully.");
        } catch (IOException e) {
            System.out.println("Error creating sample file: " + e.getMessage());
        }
    }
} 