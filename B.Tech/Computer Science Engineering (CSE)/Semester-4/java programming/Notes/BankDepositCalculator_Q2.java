/*
2. Concepts of Java Control statements, Conditional statements, loops and iterations, Wrapper classes, Scanner Class:

Using the switch statement, write a menu-driven program to calculate the maturity amount of a bank deposit.
The user is given the following options:
(i)	Term Deposit
(ii)	Recurring Deposit

For option (i) accept Principal (p), rate of interest (r) and time period in years (n). Calculate and output the maturity amount (a) receivable using the formula a = p[1 + r / 100]n.

For option (ii) accept monthly instalment (p), rate of interest (r) and time period in months (n). Calculate and output the maturity amount (a) receivable using the formula a = p * n + p * n(n + 1) / 2 * r / 100 * 1 / 12. For an incorrect option, an appropriate error message should be displayed.
[ Use Scanner Class to take input ]
*/

import java.util.Scanner;
import java.lang.Math;

public class BankDepositCalculator_Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Bank Deposit Calculator");
        System.out.println("1. Term Deposit");
        System.out.println("2. Recurring Deposit");
        System.out.print("Enter your choice (1 or 2): ");
        
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                calculateTermDeposit_Q2(scanner);
                break;
            case 2:
                calculateRecurringDeposit_Q2(scanner);
                break;
            default:
                System.out.println("Error: Invalid option selected. Please choose 1 or 2.");
        }
        
        scanner.close();
    }
    
    private static void calculateTermDeposit_Q2(Scanner scanner) {
        System.out.println("\nTerm Deposit Selected");
        
        System.out.print("Enter Principal amount (p): ");
        double principal = scanner.nextDouble();
        
        System.out.print("Enter Rate of Interest (r): ");
        double rate = scanner.nextDouble();
        
        System.out.print("Enter Time Period in years (n): ");
        double time = scanner.nextDouble();
        
        // Calculate maturity amount: a = p[1 + r / 100]^n
        double maturityAmount = principal * Math.pow(1 + rate / 100, time);
        
        System.out.printf("Maturity Amount: %.2f\n", maturityAmount);
    }
    
    private static void calculateRecurringDeposit_Q2(Scanner scanner) {
        System.out.println("\nRecurring Deposit Selected");
        
        System.out.print("Enter Monthly Installment (p): ");
        double installment = scanner.nextDouble();
        
        System.out.print("Enter Rate of Interest (r): ");
        double rate = scanner.nextDouble();
        
        System.out.print("Enter Time Period in months (n): ");
        int months = scanner.nextInt();
        
        // Calculate maturity amount: a = p * n + p * n(n + 1) / 2 * r / 100 * 1 / 12
        double maturityAmount = installment * months + 
                               (installment * months * (months + 1) / 2) * (rate / 100) * (1.0 / 12);
        
        System.out.printf("Maturity Amount: %.2f\n", maturityAmount);
    }
} 