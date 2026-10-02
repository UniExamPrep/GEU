// Add to the base class, a member function get_data() to
// initialize base class data members and another member
// function display_area() to compute and display the area
// of figures. Make display_area() as a virtual function and
// redefine this function in the derived class to suit their
// requirements.
// Using these 3 classes, design a program that will accept
// dimensions of a triangle or a rectangle interactively and
// display the area. Remember the two values given as input
// will be treated as lengths of two sides in the case of
// rectangles and as base and height in the case of triangle
// and used as follows:
// Area of rectangle = x * y
// Area of triangle = 1/2 * x * y

#include<iostream>
using namespace std;
class shape{
public:
double x,y;
void get_data(double i, double j){
x = i; y = j; }
virtual void display_area() = 0;
};
class triangle: public shape{
public:
void display_area() override{
cout<<"Area of triangle :"<<0.5*x*y<<endl;}
};
class rectangle: public shape{
public:
void display_area() override{
cout<<"Area of rectangle : "<<x*y<<endl;}
};
int main(){
triangle T; rectangle R;
int op; double i, j;
while(1){
cout<<"\nChoose: \n\t1. Area of Triangle \n\t2. Area of Rectangle \n\t3. Exit \nEnter: "; 
cin>> op;
switch(op){
case 1:
cout<<"Enter base and height of triangle : ";cin>>i>>j;
T.get_data(i,j); T.display_area();
break;
case 2:
cout<<"Enter length and breadth of rectangle : ";cin>>i>>j;
R.get_data(i,j); R.display_area();
break;
case 3: cout<<"\nExit"; exit(1);
default: cout<<"\nInvalid option!\n";
}
}
return 0;
}