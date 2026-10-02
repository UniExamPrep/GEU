import java.util.Scanner;

public class BinaryPatternFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Binary Pattern Finder - 0(1+)0");
        System.out.println("------------------------------");
        
        System.out.print("Enter a binary string (containing only 0s and 1s): ");
        String binaryString = scanner.nextLine();
        
        int count = countPatterns(binaryString);
        
        System.out.println("Input: " + binaryString);
        System.out.println("Output: " + count);
        
        scanner.close();
    }
    
    private static int countPatterns(String str) {
        int count = 0;
        
        // We need at least 3 characters for the pattern 0(1+)0
        if (str.length() < 3) {
            return 0;
        }
        
        for (int i = 0; i < str.length() - 2; i++) {
            // Check if current character is '0'
            if (str.charAt(i) == '0') {
                // Find the next '0' after at least one '1'
                int j = i + 1;
                
                // Skip all consecutive 1s
                while (j < str.length() && str.charAt(j) == '1') {
                    j++;
                }
                
                // If we found at least one '1' followed by a '0', we have a pattern
                if (j < str.length() && j > i + 1 && str.charAt(j) == '0') {
                    count++;
                    // Note: We don't increment i here to allow overlapping patterns
                }
            }
        }
        
        return count;
    }
} 