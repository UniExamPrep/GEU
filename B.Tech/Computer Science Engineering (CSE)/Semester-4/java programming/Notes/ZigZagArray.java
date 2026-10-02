import java.util.Scanner;

public class ZigZagArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("ZigZag Array Arrangement");
        System.out.println("-----------------------");
        
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        
        int[] arr = new int[size];
        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        
        arrangeZigZag(arr);
        
        System.out.println("ZigZag arranged array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        
        scanner.close();
    }
    
    private static void arrangeZigZag(int[] arr) {
        boolean flag = true; // true means '<' expected, false means '>' expected
        
        for (int i = 0; i < arr.length - 1; i++) {
            if (flag) { // '<' relation expected
                if (arr[i] > arr[i + 1]) {
                    // Swap
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            } else { // '>' relation expected
                if (arr[i] < arr[i + 1]) {
                    // Swap
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            
            flag = !flag; // Flip the flag for next comparison
        }
    }
} 