import java.util.ArrayList;
import java.util.Scanner;

public class RemoveEvenLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Remove Even Length Strings");
        System.out.println("-------------------------");
        
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
        displayList(strings);
        
        // Remove strings of even length
        removeEvenLength(strings);
        
        // Display the modified list
        System.out.println("\nAfter removing even length strings:");
        displayList(strings);
        
        scanner.close();
    }
    
    // Method to remove strings of even length from an ArrayList
    public static void removeEvenLength(ArrayList<String> list) {
        // Use an index-based approach to handle removal during iteration
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).length() % 2 == 0) {
                list.remove(i);
            }
        }
    }
    
    // Helper method to display the list
    private static void displayList(ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("(empty list)");
            return;
        }
        
        for (String str : list) {
            System.out.println("\"" + str + "\" (length: " + str.length() + ")");
        }
    }
} 