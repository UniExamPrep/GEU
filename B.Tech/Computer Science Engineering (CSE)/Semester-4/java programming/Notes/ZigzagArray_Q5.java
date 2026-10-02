/*
5. Array in Java:
Printing an array into Zigzag fashion. Suppose you were given an array of integers, and you are told to sort the integers in a zigzag pattern. In general, in a zigzag pattern, the first integer is less than the second
integer, which is greater than the third integer, which is less than the fourth integer, and so on. Hence, the converted array should be in the form of e1 < e2 > e3 < e4 > e5 < e6.
Test cases: Input 1:
7
4 3 7 8 6 2 1

Output 1:
3 7 4 8 2 6 1

Input 2:
4
1 4 3 2

Output 2:
1 4 2 3
*/

import java.util.Scanner;

public class ZigzagArray_Q5 {
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
        
        // Convert array to zigzag pattern
        zigzagSort_Q5(arr);
        
        // Display the zigzag array
        System.out.println("Array in zigzag pattern:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        
        scanner.close();
    }
    
    // Function to sort array in zigzag fashion
    private static void zigzagSort_Q5(int[] arr) {
        boolean flag = true; // true means '<' expected, false means '>' expected
        
        for (int i = 0; i < arr.length - 1; i++) {
            if (flag) { // '<' relation expected
                // If current element is greater than next element, swap them
                if (arr[i] > arr[i + 1]) {
                    swap_Q5(arr, i, i + 1);
                }
            } else { // '>' relation expected
                // If current element is less than next element, swap them
                if (arr[i] < arr[i + 1]) {
                    swap_Q5(arr, i, i + 1);
                }
            }
            
            // Flip the flag for next iteration
            flag = !flag;
        }
    }
    
    // Helper function to swap two elements in an array
    private static void swap_Q5(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
} 