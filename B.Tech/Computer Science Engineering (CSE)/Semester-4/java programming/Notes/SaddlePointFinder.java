import java.util.Scanner;

public class SaddlePointFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Saddle Point Finder");
        System.out.println("------------------");
        
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();
        
        int[][] matrix = new int[rows][cols];
        
        System.out.println("Enter the matrix elements row by row:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        // Display the matrix
        System.out.println("The matrix is:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        
        findSaddlePoint(matrix, rows, cols);
        
        scanner.close();
    }
    
    private static void findSaddlePoint(int[][] matrix, int rows, int cols) {
        boolean saddlePointFound = false;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Check if matrix[i][j] is minimum in row i
                boolean isMinInRow = true;
                for (int k = 0; k < cols; k++) {
                    if (matrix[i][k] < matrix[i][j]) {
                        isMinInRow = false;
                        break;
                    }
                }
                
                // If not minimum in row, move to next element
                if (!isMinInRow) {
                    continue;
                }
                
                // Check if matrix[i][j] is maximum in column j
                boolean isMaxInCol = true;
                for (int k = 0; k < rows; k++) {
                    if (matrix[k][j] > matrix[i][j]) {
                        isMaxInCol = false;
                        break;
                    }
                }
                
                // If both conditions are met, we found a saddle point
                if (isMaxInCol) {
                    System.out.println("Saddle point found at position (" + i + ", " + j + ")");
                    System.out.println("Value: " + matrix[i][j]);
                    saddlePointFound = true;
                }
            }
        }
        
        if (!saddlePointFound) {
            System.out.println("No saddle point found in the matrix.");
        }
    }
} 