/**
 * RemoveEvenLength_Q21.java
 * 
 * This program demonstrates a method that removes all strings of even length
 * from an ArrayList of Strings.
 */

import java.util.ArrayList;
import java.util.Iterator;

public class RemoveEvenLength_Q21 {
    public static void main(String[] args) {
        // Create an ArrayList of Strings for testing
        ArrayList<String> words = new ArrayList<>();
        words.add("apple");     // length 5 (odd)
        words.add("banana");    // length 6 (even)
        words.add("cherry");    // length 6 (even)
        words.add("date");      // length 4 (even)
        words.add("elderberry"); // length 11 (odd)
        words.add("fig");       // length 3 (odd)
        words.add("grape");     // length 5 (odd)
        
        // Print the original list
        System.out.println("Original list: " + words);
        
        // Call the removeEvenLength method
        removeEvenLength_Q21(words);
        
        // Print the modified list
        System.out.println("After removing even length strings: " + words);
    }
    
    /**
     * Removes all strings of even length from the given ArrayList.
     * 
     * @param list the ArrayList of Strings to be modified
     */
    public static void removeEvenLength_Q21(ArrayList<String> list) {
        // Method 1: Using Iterator (safer for removing elements during iteration)
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.length() % 2 == 0) {
                iterator.remove();
            }
        }
        
        // Method 2: Alternative approach using removeIf (Java 8+)
        // list.removeIf(str -> str.length() % 2 == 0);
    }
} 