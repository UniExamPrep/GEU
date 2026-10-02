/*
7. Program to find the saddle point coordinates in a given matrix. A saddle point is an element of the matrix, which is the minimum element in its row and the maximum in its column.
For example, consider the matrix given below Mat [3][3]
1 2 3
4 5 6
7 8 9
Here, 7 is the saddle point because it is the minimum element in its row and maximum element in its column.
Steps to find the saddle point coordinates in a given matrix.

1. Input the matrix from the user.
2. Use two loops, one for traversing the row and the other for traversing the column.
3. If the current element is the minimum element in its row and maximum element in its column, then return its coordinates.
Else, continue traversing.
*/

import java.util.Scanner;

public class SaddlePoint_Q7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input matrix dimensions
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();
        
        // Input matrix elements
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        // Find saddle point
        findSaddlePoint_Q7(matrix, rows, cols);
        
        scanner.close();
    }
    
    // Function to find saddle point in a matrix
    private static void findSaddlePoint_Q7(int[][] matrix, int rows, int cols) {
        boolean foundSaddlePoint = false;
        
        // Traverse each element of the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Check if current element is minimum in its row
                boolean isMinInRow = true;
                for (int k = 0; k < cols; k++) {
                    if (matrix[i][k] < matrix[i][j]) {
                        isMinInRow = false;
                        break;
                    }
                }
                
                // Check if current element is maximum in its column
                boolean isMaxInCol = true;
                for (int k = 0; k < rows; k++) {
                    if (matrix[k][j] > matrix[i][j]) {
                        isMaxInCol = false;
                        break;
                    }
                }
                
                // If both conditions are satisfied, it's a saddle point
                if (isMinInRow && isMaxInCol) {
                    System.out.println("Saddle point found at position (" + i + ", " + j + ")");
                    System.out.println("Value: " + matrix[i][j]);
                    foundSaddlePoint = true;
                }
            }
        }
        
        if (!foundSaddlePoint) {
            System.out.println("No saddle point found in the matrix.");
        }
    }
} 