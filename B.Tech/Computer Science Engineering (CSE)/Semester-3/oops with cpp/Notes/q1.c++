// An electricity board charges the following rates to
// domestic users to discourage large consumption of
// energy.
//  For the first 100 units :- 60 P per unit
//  For the next 200 units :- 80 P per unit
//  Beyond 300 units :- 90 P per unit
// All users are charged a minimum of Rs 50. If the total
// amount is more than Rs 300 then an additional surcharge
// of 15% is added. Implement a C++ program to read the
// names of users and number of units consumed and
// display the charges with names

#include <iostream>
using namespace std;
int main(){
int units;
double totalCharges= {0};
cout<<"\nEnter number of units consumed : "; cin>>units;
if (units <= 100)
totalCharges = units * 0.60;
else if (units <= 300)
totalCharges = (100 * 0.60) + ((units - 100) * 0.80);
else
totalCharges = (100 * 0.60) + (200 * 0.80) + ((units - 300) *
0.90);
if (totalCharges < 50) { totalCharges = 50;}
if (totalCharges > 300){ totalCharges += totalCharges * 0.15;}
cout << "Units Consumed : "<< units << endl;
cout << "Total Charges : Rs. " << totalCharges << endl;
return 0;
}