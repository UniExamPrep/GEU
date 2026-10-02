// Implement a Program in C++ by defining a class to
// represent a bank account. Include the following:
// Data Member: Name of the depositor, Account number,
// Type of account (Saving, Current etc.), Balance amount in
// the account.
// Member Functions: To assign initial values, To deposit an
// amount, To withdraw an amount after checking the
// balance, To display name and balance.

#include <iostream>
using namespace std;
class BankAccount {
private:
long long accNo;
string Name, accType;
float balance;
public:
BankAccount(string Name, int accNo, string accType, float balance){
this->Name = Name;
this->accNo = accNo;
this->accType = accType;
this->balance = balance;
}
void deposit (float amount){
if (amount > 0) {
balance += amount;
cout << "\nSuccessfully deposited : " << amount;
}
else cout << "\nInvalid deposit amount!";
}
void withdraw(float amount) {
if (amount > 0) {

if (amount <= balance) {
balance -= amount;
cout << "\nSuccessfully withdrawn : " << amount;
}
else cout << "\nInsufficient balance for withdrawal!";
}
else cout << "\nInvalid withdrawal amount!";
}
void display() {
cout<<"\n\nDepositor Details : "<<endl
<<"\tDepositor Name : "<<Name<<endl
<<"\tAccount Number : "<<accNo<<endl
<<"\tAccount Type : "<<accType<<endl
<<"\tCurrent Balance : "<<balance<<endl;
}
};
int main(){
BankAccount bankAccount("Khajan Bhatt", 123456789, "Current", 10000.0);
bankAccount.display();
bankAccount.deposit(1500.0);
bankAccount.withdraw(500.0);
bankAccount.display();
bankAccount.withdraw(16000.0);
return 0;
}