import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SwapPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Swap Pairs in ArrayList");
        System.out.println("----------------------");
        
        // Create an ArrayList of strings
        ArrayList<String> strings = new ArrayList<>();
        
        // Get input from user
        System.out.println("Enter strings (enter 'done' to finish):");
        
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            
            strings.add(input);
        }
        
        // Display the original list
        System.out.println("\nOriginal list:");
        System.out.println(strings);
        
        // Swap pairs in the list
        swapPairs(strings);
        
        // Display the modified list
        System.out.println("\nAfter swapping pairs:");
        System.out.println(strings);
        
        // Example with predefined list for demo
        System.out.println("\nExample with predefined list:");
        ArrayList<String> example1 = new ArrayList<>(
            Arrays.asList("four", "score", "and", "seven", "years", "ago")
        );
        System.out.println("Original: " + example1);
        swapPairs(example1);
        System.out.println("After swapping: " + example1);
        
        // Example with odd number of elements
        System.out.println("\nExample with odd number of elements:");
        ArrayList<String> example2 = new ArrayList<>(
            Arrays.asList("to", "be", "or", "not", "to", "be", "hamlet")
        );
        System.out.println("Original: " + example2);
        swapPairs(example2);
        System.out.println("After swapping: " + example2);
        
        scanner.close();
    }
    
    // Method to swap pairs of elements in an ArrayList
    public static void swapPairs(ArrayList<String> list) {
        // Iterate through the list in pairs
        for (int i = 0; i < list.size() - 1; i += 2) {
            // Swap elements at index i and i+1
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }
} 