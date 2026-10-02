/*
10. Class definition, creating objects and constructors:
Write a java program to create a class named 'Bank ' with the following data members:
• Name of depositor 
• Address of depositor
• Account Number 
• Balance in account

Class 'Bank' has a method for each of the following: 
1. Generate a unique account number for each depositor.
2. For first depositor, account number will be 1001, for second depositor it will be 1002 and so on
3. Display information and balance of depositor
4. Deposit more amount in balance of any depositor 
5. Withdraw some amount from balance deposited. 
6. Change address of depositor

After creating the class, do the following operations.
1. Enter the information (name, address, account number, balance) of the depositors. Number of depositors is to be entered by the user.
2. Print the information of any depositor.
3. Add some amount to the account of any depositor and then display final information of that depositor.
4. Remove some amount from the account of any depositor and then display final information of that depositor.
5. Change the address of any depositor and then display the final information of that depositor.
6. Randomly repeat these processes for some other bank accounts.
*/

import java.util.Scanner;

public class Bank_Q10 {
    // Static variable to generate unique account numbers
    private static int nextAccountNumber = 1001;
    
    // Data members
    private String depositorName;
    private String depositorAddress;
    private int accountNumber;
    private double balance;
    
    // Constructor
    public Bank_Q10(String name, String address, double initialBalance) {
        this.depositorName = name;
        this.depositorAddress = address;
        this.accountNumber = generateAccountNumber_Q10();
        this.balance = initialBalance;
    }
    
    // Method to generate unique account number
    private int generateAccountNumber_Q10() {
        return nextAccountNumber++;
    }
    
    // Method to display information and balance
    public void displayInfo_Q10() {
        System.out.println("\nAccount Information:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + depositorName);
        System.out.println("Address: " + depositorAddress);
        System.out.println("Balance: $" + balance);
    }
    
    // Method to deposit amount
    public void deposit_Q10(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("$" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid amount. Deposit amount must be positive.");
        }
    }
    
    // Method to withdraw amount
    public void withdraw_Q10(double amount) {
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
    public void changeAddress_Q10(String newAddress) {
        this.depositorAddress = newAddress;
        System.out.println("Address updated successfully.");
    }
    
    // Getter for account number
    public int getAccountNumber_Q10() {
        return accountNumber;
    }
    
    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input number of depositors
        System.out.print("Enter the number of depositors: ");
        int numDepositors = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        // Create array to store Bank objects
        Bank_Q10[] accounts = new Bank_Q10[numDepositors];
        
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
            
            // Create new Bank object
            accounts[i] = new Bank_Q10(name, address, balance);
            System.out.println("Account created with account number: " + accounts[i].getAccountNumber_Q10());
        }
        
        // Menu for operations
        int choice;
        do {
            System.out.println("\nBank Operations Menu:");
            System.out.println("1. Display account information");
            System.out.println("2. Deposit amount");
            System.out.println("3. Withdraw amount");
            System.out.println("4. Change address");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter account number: ");
                int accNum = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                // Find the account
                int index = -1;
                for (int i = 0; i < accounts.length; i++) {
                    if (accounts[i].getAccountNumber_Q10() == accNum) {
                        index = i;
                        break;
                    }
                }
                
                if (index == -1) {
                    System.out.println("Account not found.");
                    continue;
                }
                
                // Perform the selected operation
                switch (choice) {
                    case 1:
                        accounts[index].displayInfo_Q10();
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: $");
                        double depositAmount = scanner.nextDouble();
                        accounts[index].deposit_Q10(depositAmount);
                        accounts[index].displayInfo_Q10();
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: $");
                        double withdrawAmount = scanner.nextDouble();
                        accounts[index].withdraw_Q10(withdrawAmount);
                        accounts[index].displayInfo_Q10();
                        break;
                    case 4:
                        System.out.print("Enter new address: ");
                        String newAddress = scanner.nextLine();
                        accounts[index].changeAddress_Q10(newAddress);
                        accounts[index].displayInfo_Q10();
                        break;
                }
            }
        } while (choice != 5);
        
        System.out.println("Thank you for using the Bank System!");
        scanner.close();
    }
} 