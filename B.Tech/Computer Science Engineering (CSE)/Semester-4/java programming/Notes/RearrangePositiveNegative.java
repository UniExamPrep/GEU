import java.util.Scanner;

public class RearrangePositiveNegative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Rearrange Positive and Negative Numbers");
        System.out.println("--------------------------------------");
        
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        
        int[] arr = new int[size];
        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        
        rearrangeArray(arr);
        
        System.out.println("Rearranged array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        
        scanner.close();
    }
    
    private static void rearrangeArray(int[] arr) {
        int j = 0; // Position to place the next negative number
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                // If current element is negative, swap it with the
                // element at position j and increment j
                if (i != j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
    }
} 