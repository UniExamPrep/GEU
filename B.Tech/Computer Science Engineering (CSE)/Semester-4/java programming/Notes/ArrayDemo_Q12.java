/*
12. Method overloading (Compile time Polymorphism):
Write a Java program to create a class called
ArrayDemo and overload arrayFunc() function.

void arrayFunc(int [], int)  To find all pairs of elements in an Array whose sum is equal to a given number :

Array numbers= [4, 6, 5, -10, 8, 5, 20], target=10
Output :

Pairs of elements whose sum is 10 are : 4 + 6 = 10
5 + 5 = 10
-10 + 20 = 10
void arrayFunc(int A[], int p, int B[], int q)  Given two sorted arrays A and B of size p and q, Overload method arrayFunc() to merge elements of A with B by maintaining the sorted order i.e. fill A with first p smallest elements and fill B with remaining elements.

Example:
Input :
int[] A = { 1, 5, 6, 7, 8, 10 }
int[] B = { 2, 4, 9 }
Output:
Sorted Arrays:
A: [1, 2, 4, 5, 6, 7]
B: [8, 9, 10]
(Use	Compile	time	Polymorphism	Method Overloading)
*/

import java.util.Arrays;

public class ArrayDemo_Q12 {
    // Method to find pairs with a given sum
    public void arrayFunc_Q12(int[] arr, int target) {
        System.out.println("Finding pairs with sum = " + target);
        
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
            System.out.println("No pairs found with sum = " + target);
        }
    }
    
    // Overloaded method to merge two sorted arrays
    public void arrayFunc_Q12(int[] A, int p, int[] B, int q) {
        System.out.println("Merging two sorted arrays");
        
        // Create a copy of original arrays for display
        int[] originalA = Arrays.copyOf(A, p);
        int[] originalB = Arrays.copyOf(B, q);
        
        // Merge both arrays
        int[] merged = new int[p + q];
        int k = 0;
        
        // Copy elements from both arrays
        for (int i = 0; i < p; i++) {
            merged[k++] = A[i];
        }
        
        for (int i = 0; i < q; i++) {
            merged[k++] = B[i];
        }
        
        // Sort the merged array
        Arrays.sort(merged);
        
        // Fill A with first p smallest elements
        for (int i = 0; i < p; i++) {
            A[i] = merged[i];
        }
        
        // Fill B with remaining elements
        for (int i = 0; i < q; i++) {
            B[i] = merged[p + i];
        }
        
        // Display the result
        System.out.println("Original Arrays:");
        System.out.println("A: " + Arrays.toString(originalA));
        System.out.println("B: " + Arrays.toString(originalB));
        
        System.out.println("Sorted Arrays:");
        System.out.println("A: " + Arrays.toString(A));
        System.out.println("B: " + Arrays.toString(B));
    }
    
    // Main method for testing
    public static void main(String[] args) {
        ArrayDemo_Q12 demo = new ArrayDemo_Q12();
        
        // Test first method - find pairs with sum = 10
        int[] numbers = {4, 6, 5, -10, 8, 5, 20};
        int target = 10;
        
        System.out.println("Test 1: Find pairs with sum = " + target);
        System.out.println("Array: " + Arrays.toString(numbers));
        demo.arrayFunc_Q12(numbers, target);
        
        System.out.println();
        
        // Test second method - merge sorted arrays
        int[] A = {1, 5, 6, 7, 8, 10};
        int[] B = {2, 4, 9};
        
        System.out.println("Test 2: Merge sorted arrays");
        demo.arrayFunc_Q12(A, A.length, B, B.length);
    }
} 