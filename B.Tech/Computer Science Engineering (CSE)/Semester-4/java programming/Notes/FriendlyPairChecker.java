import java.util.Scanner;

public class FriendlyPairChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Friendly Pair Checker");
        System.out.println("--------------------");
        
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        
        if (isFriendlyPair(num1, num2)) {
            System.out.println("Friendly Pair");
        } else {
            System.out.println("Not Friendly Pair");
        }
        
        scanner.close();
    }
    
    private static boolean isFriendlyPair(int num1, int num2) {
        // Calculate sum of divisors for both numbers
        int sum1 = sumOfDivisors(num1);
        int sum2 = sumOfDivisors(num2);
        
        // Calculate abundances (sum of divisors / number)
        double abundance1 = (double) sum1 / num1;
        double abundance2 = (double) sum2 / num2;
        
        // Numbers are friendly if they have the same abundance
        return Double.compare(abundance1, abundance2) == 0;
    }
    
    private static int sumOfDivisors(int num) {
        int sum = 0;
        
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        
        return sum;
    }
} 