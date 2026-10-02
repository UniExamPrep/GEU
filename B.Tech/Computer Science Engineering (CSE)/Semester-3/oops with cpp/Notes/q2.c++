// Construct a C++ program that removes a specific
// character from a given string and return updated string. 

#include <iostream>
using namespace std;
string removeCharacter (string & inputStr, char charToRemove){
string resultStr;
for (const char & i : inputStr){
if (i != charToRemove)
resultStr += i;
}
return resultStr;
}
int main(){
string inputStr; char charToRemove;
cout<<"\nEnter the string : ";
getline(cin, inputStr);
cout<<"Enter the character to be removed : ";
cin>>charToRemove;
string resultStr = removeCharacter(inputStr, charToRemove);
cout<<"Modified String : "<<resultStr<<endl;
return 0;
}