// Using the concept of operator overloading. Implement a program to overload the following:
// a. Unary –
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

    // Overload unary - operator
    Counter operator-() {
        return Counter(-count);
    }

    // Overload pre-increment operator
    Counter& operator++() {
        ++count;
        return *this;
    }

    // Overload post-increment operator
    Counter operator++(int) {
        Counter temp = *this;
        ++count;
        return temp;
    }

    // Overload pre-decrement operator
    Counter& operator--() {
        --count;
        return *this;
    }

    // Overload post-decrement operator
    Counter operator--(int) {
        Counter temp = *this;
        --count;
        return temp;
    }

    // Get current value of count
    int getValue() const {
        return count;
    }

    // Display count
    void display() const {
        cout << "Count: " << count << endl;
    }
};

int main() {
    Counter c1(5);

    cout << "Initial count: ";
    c1.display();

    // Unary - operator
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