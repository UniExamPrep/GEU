import java.util.Scanner;

public class Bank {
    // Data members
    private String depositorName;
    private String depositorAddress;
    private int accountNumber;
    private double balance;
    
    // Static variable to generate unique account numbers
    private static int nextAccountNumber = 1001;
    
    // Constructor
    public Bank(String name, String address, double initialBalance) {
        this.depositorName = name;
        this.depositorAddress = address;
        this.accountNumber = nextAccountNumber++;
        this.balance = initialBalance;
    }
    
    // Method to display depositor information and balance
    public void displayInfo() {
        System.out.println("\nDepositor Information:");
        System.out.println("Name: " + depositorName);
        System.out.println("Address: " + depositorAddress);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
    
    // Method to deposit amount
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("$" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid amount. Deposit amount must be positive.");
        }
    }
    
    // Method to withdraw amount
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("$" + amount + " withdrawn successfully.");
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Invalid amount. Withdrawal amount must be positive.");
        }
    }
    
    // Method to change address
    public void changeAddress(String newAddress) {
        this.depositorAddress = newAddress;
        System.out.println("Address updated successfully.");
    }
    
    // Getter for account number
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Bank Management System");
        System.out.println("---------------------");
        
        // Get number of depositors
        System.out.print("Enter the number of depositors: ");
        int numDepositors = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        // Create array to store Bank objects
        Bank[] accounts = new Bank[numDepositors];
        
        // Input information for each depositor
        for (int i = 0; i < numDepositors; i++) {
            System.out.println("\nEnter details for depositor " + (i + 1) + ":");
            
            System.out.print("Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Address: ");
            String address = scanner.nextLine();
            
            System.out.print("Initial Balance: $");
            double balance = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            
            accounts[i] = new Bank(name, address, balance);
            System.out.println("Account created successfully with Account Number: " + accounts[i].getAccountNumber());
        }
        
        // Menu-driven operations
        int choice = 0;
        do {
            System.out.println("\nOperations Menu:");
            System.out.println("1. Display depositor information");
            System.out.println("2. Deposit amount");
            System.out.println("3. Withdraw amount");
            System.out.println("4. Change address");
            System.out.println("5. Exit");
            
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();
            
            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter Account Number: ");
                int accNum = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                // Find the account
                Bank account = null;
                for (Bank acc : accounts) {
                    if (acc.getAccountNumber() == accNum) {
                        account = acc;
                        break;
                    }
                }
                
                if (account == null) {
                    System.out.println("Account not found.");
                    continue;
                }
                
                switch (choice) {
                    case 1:
                        account.displayInfo();
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: $");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        account.displayInfo();
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: $");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        account.displayInfo();
                        break;
                    case 4:
                        System.out.print("Enter new address: ");
                        String newAddress = scanner.nextLine();
                        account.changeAddress(newAddress);
                        account.displayInfo();
                        break;
                }
            }
        } while (choice != 5);
        
        System.out.println("Thank you for using the Bank Management System.");
        scanner.close();
    }
} 