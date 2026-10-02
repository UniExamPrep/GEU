/**
 * AlternateList_Q23.java
 * 
 * This program demonstrates a method that accepts two Lists of integers
 * and returns a new List containing alternating elements from the two lists.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlternateList_Q23 {
    public static void main(String[] args) {
        // Test case 1: Lists of equal length
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(6, 7, 8, 9, 10);
        
        List<Integer> result1 = alternate_Q23(list1, list2);
        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);
        System.out.println("Alternating result: " + result1);
        // Expected output: [1, 6, 2, 7, 3, 8, 4, 9, 5, 10]
        
        // Test case 2: First list is longer
        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> list4 = Arrays.asList(8, 9, 10);
        
        List<Integer> result2 = alternate_Q23(list3, list4);
        System.out.println("\nList 3: " + list3);
        System.out.println("List 4: " + list4);
        System.out.println("Alternating result: " + result2);
        // Expected output: [1, 8, 2, 9, 3, 10, 4, 5, 6, 7]
        
        // Test case 3: Second list is longer
        List<Integer> list5 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list6 = Arrays.asList(6, 7, 8, 9, 10, 11, 12);
        
        List<Integer> result3 = alternate_Q23(list5, list6);
        System.out.println("\nList 5: " + list5);
        System.out.println("List 6: " + list6);
        System.out.println("Alternating result: " + result3);
        // Expected output: [1, 6, 2, 7, 3, 8, 4, 9, 5, 10, 11, 12]
    }
    
    /**
     * Returns a new List containing alternating elements from the two input lists.
     * If the lists do not contain the same number of elements, the remaining elements
     * from the longer list are placed consecutively at the end.
     * 
     * @param list1 the first List of integers
     * @param list2 the second List of integers
     * @return a new List containing alternating elements from the two input lists
     */
    public static List<Integer> alternate_Q23(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        
        // Determine the minimum length of the two lists
        int minLength = Math.min(list1.size(), list2.size());
        
        // Add alternating elements from both lists
        for (int i = 0; i < minLength; i++) {
            result.add(list1.get(i));
            result.add(list2.get(i));
        }
        
        // Add remaining elements from list1 if it's longer
        for (int i = minLength; i < list1.size(); i++) {
            result.add(list1.get(i));
        }
        
        // Add remaining elements from list2 if it's longer
        for (int i = minLength; i < list2.size(); i++) {
            result.add(list2.get(i));
        }
        
        return result;
    }
} 