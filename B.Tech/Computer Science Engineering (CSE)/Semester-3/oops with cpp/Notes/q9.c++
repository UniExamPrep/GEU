// Construct a Program in C++ to show the working of
// function overloading(compile time polymorphism) by
// using a function named calculate Area () to calculate area
// of square, rectangle and triangle using different
// signatures as required.

#include <iostream>
using namespace std;
int calculateArea(int side) {
return side * side;
}
int calculateArea(int length, int breadth) {
return length * breadth;
}
double calculateArea(double base, double height) {
return 0.5 * base * height;
}
int main() {
int squareArea = calculateArea(5);
cout << "Area of Square : " << squareArea << endl;
int rectangleArea = calculateArea(4, 6);
cout << "Area of Rectangle : " << rectangleArea << endl;
double triangleArea = calculateArea(3.0, 5.0);
cout << "Area of Triangle : " << triangleArea << endl;
return 0;
}