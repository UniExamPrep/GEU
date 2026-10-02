import java.util.Arrays;
import java.util.Scanner;

public class ArrayDemo {
    // Method to find pairs with sum equal to target
    public void arrayFunc(int[] arr, int target) {
        System.out.println("\nPairs of elements whose sum is " + target + " are:");
        boolean pairFound = false;
        
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println(arr[i] + " + " + arr[j] + " = " + target);
                    pairFound = true;
                }
            }
        }
        
        if (!pairFound) {
            System.out.println("No pairs found with sum " + target);
        }
    }
    
    // Overloaded method to merge two sorted arrays
    public void arrayFunc(int[] A, int p, int[] B, int q) {
        System.out.println("\nBefore merging:");
        System.out.println("A: " + Arrays.toString(A));
        System.out.println("B: " + Arrays.toString(B));
        
        // Create a combined array
        int[] merged = new int[p + q];
        int i = 0, j = 0, k = 0;
        
        // Merge arrays into the combined array
        while (i < p && j < q) {
            if (A[i] <= B[j]) {
                merged[k++] = A[i++];
            } else {
                merged[k++] = B[j++];
            }
        }
        
        // Copy remaining elements from A, if any
        while (i < p) {
            merged[k++] = A[i++];
        }
        
        // Copy remaining elements from B, if any
        while (j < q) {
            merged[k++] = B[j++];
        }
        
        // Copy the smallest p elements to A
        for (i = 0; i < p; i++) {
            A[i] = merged[i];
        }
        
        // Copy the remaining elements to B
        for (i = 0; i < q; i++) {
            B[i] = merged[p + i];
        }
        
        System.out.println("\nAfter merging:");
        System.out.println("A: " + Arrays.toString(A));
        System.out.println("B: " + Arrays.toString(B));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDemo demo = new ArrayDemo();
        
        // Test first overloaded method
        System.out.println("Testing the first method: Find pairs with a given sum");
        System.out.println("---------------------------------------------------");
        
        int[] numbers = {4, 6, 5, -10, 8, 5, 20};
        System.out.println("Array: " + Arrays.toString(numbers));
        
        System.out.print("Enter the target sum: ");
        int target = scanner.nextInt();
        
        demo.arrayFunc(numbers, target);
        
        // Test second overloaded method
        System.out.println("\nTesting the second method: Merge two sorted arrays");
        System.out.println("--------------------------------------------------");
        
        System.out.print("Enter the size of first array A: ");
        int p = scanner.nextInt();
        
        int[] A = new int[p];
        System.out.println("Enter " + p + " elements for array A in sorted order:");
        for (int i = 0; i < p; i++) {
            A[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the size of second array B: ");
        int q = scanner.nextInt();
        
        int[] B = new int[q];
        System.out.println("Enter " + q + " elements for array B in sorted order:");
        for (int i = 0; i < q; i++) {
            B[i] = scanner.nextInt();
        }
        
        demo.arrayFunc(A, p, B, q);
        
        scanner.close();
    }
} 