// Define a class Hotel in C++ with the following
// specifications:
// Private members:
// • Rno : Data member to store room number
// • Name : Data member to store customer name
// • Tariff : Data member to store per day charges
// • NOD : Data member to store number of days of stay
// • CALC() : Function to calculate and return amount as
// NOD*Tariff ,and if the value of days* Tariff >10000,
// then total amount is 1.05* days*Tariff.
// Public members:
// • Checkin() Function to enter the content Rno, Name,
// Tariff and NOD
// • Checkout() Function to display Rno, Name, Tariff,
// NOD and Amount (amount to be displayed by calling
// function) CALC()

#include <iostream>
using namespace std;
class Hotel {
private:
int RNo, NOD;
string Name;
float tarrif;
float Calc (void){
float totalAmount = NOD * tarrif;
if (totalAmount > 10000) totalAmount *= 1.05;
return totalAmount;
}
public:
void CheckIn (void){
cout<<"\nEnter Room Number : "; cin>>RNo;
cin.ignore(INT_MAX, '\n');
cout<<"Enter Customer Name : "; getline(cin, Name);
cout<<"Enter Tarrif per Day : "; cin>>tarrif;
cout<<"Enter the Number of Days of stay : "; cin>>NOD;
return;
}
void CheckOut (void){
cout<<"\nDetails : "<<endl
<<"\tRoom Number : "<<RNo<<endl
<<"\tName of Customer : "<<Name<<endl
<<"\tTarrif per Day : "<<tarrif<<endl
<<"\tNumber of Days of stay : "<<NOD<<endl<<endl
<<"Total amount to Pay : "<< Calc()<<endl;
return;
}
};
int main(){
Hotel royalWindsor;
royalWindsor.CheckIn();
royalWindsor.CheckOut();
return 0;
}