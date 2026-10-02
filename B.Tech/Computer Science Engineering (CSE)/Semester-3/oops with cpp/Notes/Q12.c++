// Create a class called Time that has separate int member data for hours, minutes and
// seconds. One constructor should initialize this data to 0, and another should
// initialize it to fixed values. A member function should display it in 11:59:59 format.
// A member function named add() should add two objects of type time passed as
// arguments. A main ( ) program should create two initialized values together, leaving
// the result in the third time variable. Finally it should display the value of this third
// variable.

#include <iostream>
using namespace std;

class Time {
private:
    int hours;
    int minutes;
    int seconds;

public:
    // Default constructor
    Time() : hours(0), minutes(0), seconds(0) {}

    // Parameterized constructor
    Time(int h, int m, int s) : hours(h), minutes(m), seconds(s) {}

    // Display time in HH:MM:SS format
    void displayTime() const {
        cout << (hours < 10 ? "0" : "") << hours << ":"
            << (minutes < 10 ? "0" : "") << minutes << ":"
            << (seconds < 10 ? "0" : "") << seconds << endl;
    }

    // Add two Time objects
    void add(const Time& t1, const Time& t2) {
        seconds = t1.seconds + t2.seconds;
        minutes = t1.minutes + t2.minutes;
        hours = t1.hours + t2.hours;

        if (seconds >= 60) {
            seconds -= 60;
            minutes++;
        }

        if (minutes >= 60) {
            minutes -= 60;
            hours++;
        }
    }
};

int main() {
    // Create Time objects
    Time t1(1, 45, 50);
    Time t2(2, 30, 20);
    Time t3;

    // Add times
    t3.add(t1, t2);

    // Display times
    cout << "Time 1: ";
    t1.displayTime();

    cout << "Time 2: ";
    t2.displayTime();

    cout << "Total Time: ";
    t3.displayTime();

    return 0;
}