import java.util.Scanner;

public class BankDepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Bank Deposit Calculator");
        System.out.println("----------------------");
        System.out.println("1. Term Deposit");
        System.out.println("2. Recurring Deposit");
        System.out.print("Enter your choice (1 or 2): ");
        
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                calculateTermDeposit(scanner);
                break;
            case 2:
                calculateRecurringDeposit(scanner);
                break;
            default:
                System.out.println("Error: Invalid option selected.");
        }
        
        scanner.close();
    }
    
    private static void calculateTermDeposit(Scanner scanner) {
        System.out.println("\nTerm Deposit Calculator");
        System.out.println("----------------------");
        
        System.out.print("Enter principal amount: ");
        double principal = scanner.nextDouble();
        
        System.out.print("Enter rate of interest (% per annum): ");
        double rate = scanner.nextDouble();
        
        System.out.print("Enter time period (in years): ");
        int years = scanner.nextInt();
        
        // Calculate maturity amount using: a = p[1 + r/100]^n
        double maturityAmount = principal * Math.pow(1 + rate/100, years);
        
        System.out.printf("Maturity Amount: %.2f\n", maturityAmount);
    }
    
    private static void calculateRecurringDeposit(Scanner scanner) {
        System.out.println("\nRecurring Deposit Calculator");
        System.out.println("--------------------------");
        
        System.out.print("Enter monthly installment: ");
        double monthlyInstallment = scanner.nextDouble();
        
        System.out.print("Enter rate of interest (% per annum): ");
        double rate = scanner.nextDouble();
        
        System.out.print("Enter time period (in months): ");
        int months = scanner.nextInt();
        
        // Calculate maturity amount using: a = p*n + p*n(n+1)/2*r/100*1/12
        double maturityAmount = monthlyInstallment * months + 
                                monthlyInstallment * months * (months + 1) / 2 * rate / 100 * 1 / 12;
        
        System.out.printf("Maturity Amount: %.2f\n", maturityAmount);
    }
} 