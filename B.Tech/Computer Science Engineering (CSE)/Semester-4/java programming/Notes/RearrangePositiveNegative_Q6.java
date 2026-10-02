/*
6. The problem to rearrange positive and negative numbers in an array.
Method: This approach moves all negative numbers to the beginning and positive numbers to the end but changes the order of appearance of the elements of the array.
Steps:

1. Declare an array and input the array elements.
2. Start traversing the array and if the current element is negative, swap the current element with the first positive element and continue traversing until all the elements have been encountered.
3. Print the rearranged array.

Test case:

• Input:	1 -1 2 -2 3 -3
  Output:  	-1 -2 -3 1 3 2
*/

import java.util.Scanner;

public class RearrangePositiveNegative_Q6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input array size
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        
        // Input array elements
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Rearrange positive and negative numbers
        rearrangeArray_Q6(arr);
        
        // Display the rearranged array
        System.out.println("Rearranged array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        
        scanner.close();
    }
    
    // Function to rearrange array such that all negative numbers come first
    private static void rearrangeArray_Q6(int[] arr) {
        int j = 0; // Index for the first positive element
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) { // If current element is negative
                if (i != j) {
                    // Swap current negative element with first positive element
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++; // Increment index of first positive element
            }
        }
    }
} 