/**
 * SwapPairs_Q22.java
 * 
 * This program demonstrates a method that switches the order of values
 * in an ArrayList of Strings in a pairwise fashion.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class SwapPairs_Q22 {
    public static void main(String[] args) {
        // Test case 1: Even number of elements
        ArrayList<String> list1 = new ArrayList<>(
            Arrays.asList("four", "score", "and", "seven", "years", "ago")
        );
        System.out.println("Original list 1: " + list1);
        swapPairs_Q22(list1);
        System.out.println("After swapping pairs: " + list1);
        // Expected output: [score, four, seven, and, ago, years]
        
        // Test case 2: Odd number of elements
        ArrayList<String> list2 = new ArrayList<>(
            Arrays.asList("to", "be", "or", "not", "to", "be", "hamlet")
        );
        System.out.println("\nOriginal list 2: " + list2);
        swapPairs_Q22(list2);
        System.out.println("After swapping pairs: " + list2);
        // Expected output: [be, to, not, or, be, to, hamlet]
    }
    
    /**
     * Switches the order of values in an ArrayList of Strings in a pairwise fashion.
     * If there are an odd number of values, the final element is not moved.
     * 
     * @param list the ArrayList of Strings to be modified
     */
    public static void swapPairs_Q22(ArrayList<String> list) {
        // Iterate through the list in steps of 2
        for (int i = 0; i < list.size() - 1; i += 2) {
            // Swap the current element with the next element
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }
} 