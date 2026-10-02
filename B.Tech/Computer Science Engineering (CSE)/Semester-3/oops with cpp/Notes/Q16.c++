// Using the concept of operator overloading. Implement a program to overload the following:
// With the help of friend function
// a. Unary - -
// b. Unary ++ preincrement, postincrement
// c. Unary -- predecrement, postdecrement

#include <iostream>
using namespace std;

class Counter {
private:
    int count;

public:
    // Constructor with default argument
    Counter(int c = 0) : count(c) {}

    // Friend function for Unary -
    friend Counter operator-(Counter &c) {
        return Counter(-c.count);
    }

    // Friend function for Unary ++ (pre-increment)
    friend Counter& operator++(Counter &c) {
        ++c.count;
        return c;
    }

    // Friend function for Unary ++ (post-increment)
    friend Counter operator++(Counter &c, int) {
        Counter temp = c;
        c.count++;
        return temp;
    }

    // Friend function for Unary -- (pre-decrement)
    friend Counter& operator--(Counter &c) {
        --c.count;
        return c;
    }

    // Friend function for Unary -- (post-decrement)
    friend Counter operator--(Counter &c, int) {
        Counter temp = c;
        c.count--;
        return temp;
    }

    // Function to display the value of count
    void display() const {
        cout << "Count: " << count << endl;
    }
};

int main() {
    Counter c1(5);

    cout << "Initial count: ";
    c1.display();

    // Unary -
    Counter c2 = -c1;
    cout << "Unary - : ";
    c2.display();

    // Pre-increment
    cout << "Pre-increment: ";
    Counter c3 = ++c1;
    c3.display();

    // Post-increment
    cout << "Post-increment: ";
    Counter c4 = c1++;
    c4.display();
    cout << "After post-increment: ";
    c1.display();

    // Pre-decrement
    cout << "Pre-decrement: ";
    Counter c5 = --c1;
    c5.display();

    // Post-decrement
    cout << "Post-decrement: ";
    Counter c6 = c1--;
    c6.display();
    cout << "After post-decrement: ";
    c1.display();

    return 0;
}