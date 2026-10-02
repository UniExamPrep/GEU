import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AlternateLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Alternate Lists");
        System.out.println("--------------");
        
        // Example with predefined lists
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(6, 7, 8, 9, 10, 11, 12));
        
        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);
        
        List<Integer> result = alternate(list1, list2);
        
        System.out.println("Alternated List: " + result);
        
        // Interactive version
        System.out.println("\nCreate your own lists:");
        
        // Get first list
        List<Integer> userList1 = new ArrayList<>();
        System.out.println("Enter integers for first list (enter a non-integer to finish):");
        while (scanner.hasNextInt()) {
            userList1.add(scanner.nextInt());
        }
        scanner.next(); // Consume the non-integer token
        
        // Get second list
        List<Integer> userList2 = new ArrayList<>();
        System.out.println("Enter integers for second list (enter a non-integer to finish):");
        while (scanner.hasNextInt()) {
            userList2.add(scanner.nextInt());
        }
        
        System.out.println("Your list 1: " + userList1);
        System.out.println("Your list 2: " + userList2);
        
        List<Integer> userResult = alternate(userList1, userList2);
        
        System.out.println("Your alternated list: " + userResult);
        
        scanner.close();
    }
    
    // Method to alternate elements from two lists
    public static List<Integer> alternate(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        
        // Determine the maximum index for the shorter list
        int minSize = Math.min(list1.size(), list2.size());
        
        // Add alternating elements from both lists
        for (int i = 0; i < minSize; i++) {
            result.add(list1.get(i));
            result.add(list2.get(i));
        }
        
        // Add remaining elements from the longer list
        if (list1.size() > minSize) {
            for (int i = minSize; i < list1.size(); i++) {
                result.add(list1.get(i));
            }
        } else if (list2.size() > minSize) {
            for (int i = minSize; i < list2.size(); i++) {
                result.add(list2.get(i));
            }
        }
        
        return result;
    }
} 