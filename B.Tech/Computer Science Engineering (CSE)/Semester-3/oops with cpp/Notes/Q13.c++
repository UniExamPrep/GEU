// Create class SavingsAccount. Use a static variable annualInterestRate to store the
// annual interest rate for all account holders. Each object of the class contains a private
// instance variable savingsBalance indicating the amount the saver currently has on
// deposit. Provide method For batches admitted in 2023-24 and 2024-25 onwards,
// Applicable from Academic Session 2024-25 calculateMonthlyInterest() to calculate
// the monthly interest by multiplying the savingsBalance by annualInterestRate divided
// by 12.This interest should be added tosavingsBalance. Provide a static method
// modifyInterestRate() that sets the annualInterestRate to a new value. Write a program
// to test class SavingsAccount. Instantiate two savingsAccount objects, saver1 and
// saver2, with balances of Rs2000.00 and Rs3000.00, respectively. Set
// annualInterestRate to 4%, then calculate the monthly interest and print the new
// balances for both savers. Then set the annualInterestRate to 5%, calculate the next
// month’s interest and print the new balances for both savers.

#include <iostream>
using namespace std;

class SavingsAccount {
private:
    double savingsBalance;                    // Instance variable to store balance
    static double annualInterestRate;         // Static variable to store interest rate

public:
    // Constructor to initialize balance
    SavingsAccount(double balance) : savingsBalance(balance) {}

    // Method to calculate and add monthly interest to the balance
    void calculateMonthlyInterest() {
        double monthlyInterest = savingsBalance * annualInterestRate / 12;
        savingsBalance += monthlyInterest;
    }

    // Static method to modify the interest rate
    static void modifyInterestRate(double newRate) {
        annualInterestRate = newRate;
    }

    // Method to get the current balance
    double getBalance() const {
        return savingsBalance;
    }
};

// Definition and initialization of static member
double SavingsAccount::annualInterestRate = 0.0;

int main() {
    // Create two SavingsAccount objects
    SavingsAccount saver1(2000.0);
    SavingsAccount saver2(3000.0);

    // Set interest rate to 4%
    SavingsAccount::modifyInterestRate(0.04);

    // Calculate monthly interest for both savers
    saver1.calculateMonthlyInterest();
    saver2.calculateMonthlyInterest();

    // Display balances after first interest calculation
    cout << "Saver 1 balance: " << saver1.getBalance() << endl;
    cout << "Saver 2 balance: " << saver2.getBalance() << endl;

    // Set interest rate to 5%
    SavingsAccount::modifyInterestRate(0.05);

    // Calculate monthly interest for both savers again
    saver1.calculateMonthlyInterest();
    saver2.calculateMonthlyInterest();

    // Display balances after second interest calculation
    cout << "Saver 1 balance: " << saver1.getBalance() << endl;
    cout << "Saver 2 balance: " << saver2.getBalance() << endl;

    return 0;
}