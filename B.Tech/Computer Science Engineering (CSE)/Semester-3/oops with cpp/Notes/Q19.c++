// Implement a real case scenario by a proper C++ code to
// provide the solution to Diamond Problem in C++.

#include <iostream>
using namespace std;
class College{
public:
string college_name;
string address;
};
class Student: public virtual College{
public:
unsigned int age = 18, enroll_no = 230104702;;
string name = "XYZ";
float marks = 75;
void display(){
cout<<"\nName: "<<name <<"\nAge: "<<age
<<"\nEnroll Number: "<<enroll_no
<<"\nMarks: "<<marks;
}
};
class Faculty: public virtual College{
public:
string faculty_name = "ABC";
int faculty_code = 101, experience = 10, age = 40;
float salary = 50000;
string deptt = "Computer Science Engineering", gender = "Male";
void display(){
cout<<"\nFaculty Name: "<<faculty_name
<<"\nFaculty code: "<<faculty_code
<<"\nSalary: "<<salary <<"\nDepartment: "<<deptt
<<"\nAge: "<<age <<"\nGender: "<<gender
<<"\nExperience: "<<experience<<" years";
}
};
class Person : public Faculty, public Student {};
int main(){
Person P;
P.college_name = "Graphic Era Hill university";
P.address = "Bhimtal";
//Accessing data members of college class (removing ambiguity)
cout<<"\n\t\tCOLLEGE DETAILS";
cout<<"\nCollege Name: "<<P.college_name;
cout<<"\nCollege Address: "<<P.address<<endl;
cout<<"\n\t\tFACULTY DETAILS";
P.Faculty::display();
cout<<endl<<"\n\t\tSTUDENT DETAILS";
P.Student::display();
return 0;
}