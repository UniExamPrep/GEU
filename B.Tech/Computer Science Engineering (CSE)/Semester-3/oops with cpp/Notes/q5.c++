// Implement a C++ program to demonstrate the concept of
// data abstraction using the concept of Class and Objects. 

#include <iostream>
using namespace std;
class Employee {
// Private Data members - Hidden from outside
string name;
double salary;
static int id;
static void giveId (void){ id++; } //Static member ID is abstracted
public:
// Public methods - Provides interface to the outside
void setDetails(string empName, double empSalary) {
name = empName;
salary = empSalary;
giveId();
}
void displayDetails() {
cout << "\nEmployee Name : " << name << endl;
cout << "Employee ID : " << id << endl;
cout << "Employee Salary : $" << salary << endl;
}
};
int Employee :: id = 0;
int main() {
Employee emp;
emp.setDetails("Khajan Bhatt", 55000.50);
emp.displayDetails();
return 0;
}