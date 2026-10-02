import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class PalindromeCounter {
    public static void main(String[] args) {
        String fileName = "myfile.txt";
        int palindromeCount = 0;
        
        System.out.println("Palindrome Counter");
        System.out.println("-----------------");
        
        try {
            // Create a sample file if needed (for testing)
            createSampleFile();
            
            // Open the file for reading
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            
            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                // Tokenize the line to get individual words
                StringTokenizer tokenizer = new StringTokenizer(line, " \t\n\r\f,.:;?!\"'()[]{}<>");
                
                while (tokenizer.hasMoreTokens()) {
                    String word = tokenizer.nextToken();
                    
                    // Check if the word is a palindrome
                    if (isPalindrome(word) && word.length() > 1) {
                        System.out.println("Palindrome found: " + word);
                        palindromeCount++;
                    }
                }
            }
            
            reader.close();
            
            System.out.println("\nTotal palindromes found: " + palindromeCount);
            
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
    
    // Method to check if a word is a palindrome
    private static boolean isPalindrome(String word) {
        // Convert to uppercase for case-insensitive comparison
        word = word.toUpperCase();
        
        int left = 0;
        int right = word.length() - 1;
        
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    // Method to create a sample file for testing
    private static void createSampleFile() {
        // This method would create a test file, but we'll skip implementation
        // since it would require writing to the file system
        
        // In a real implementation, you would:
        // 1. Create a FileWriter for "myfile.txt"
        // 2. Write sample content with palindromes
        // 3. Close the writer
        
        System.out.println("Note: Please ensure 'myfile.txt' exists with content to test this program.");
        System.out.println("Sample content could be:");
        System.out.println("My name is NITIN");
        System.out.println("Hello aaa and bbb word");
        System.out.println("How are You");
        System.out.println("ARORA is my friend");
    }
} 