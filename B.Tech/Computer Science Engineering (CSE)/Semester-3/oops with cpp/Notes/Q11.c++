// Imagine a tollbooth with a class called TollBooth. The two data items are of type unsigned
// int and double to hold the total number of cars and total amount of money collected. A
// constructor initializes both of these data members to 0. A member function called
// payingCar( )increments the car total and adds 0.5 to the cash total. Another function called
// nonPayCar( ) increments the car total but adds nothing to the cash total. Finally a member
// function called display( )shows the two totals. Include a program to test this class. This
// program should allow the user to push one key to count a paying car and another to count a
// non paying car. Pushing the ESC key should cause the program to print out the total number
// of cars and total cash and then exit.

#include <iostream>
using namespace std;

class tollbooth {
private:
    unsigned int totalcars;  // Total number of cars
    double totalcash;        // Total cash collected

public:
    // Constructor to initialize data members
    tollbooth() : totalcars(0), totalcash(0.0) {}

    // Method to record a paying car
    void payingcar() {
        totalcars++;
        totalcash += 0.5; // Increment cash by 0.5 for a paying car
    }

    // Method to record a non-paying car
    void nonpaycar() {
        totalcars++;
    }

    // Method to display total cars and total cash collected
    void display() const {
        cout << "Total number of cars: " << totalcars << endl;
        cout << "Total cash collected: Rs. " << totalcash << endl;
    }
};

int main() {
    tollbooth tollbooth; // Create an object of class tollbooth
    char choice;

    cout << "Press 'p' for paying car" << endl;
    cout << "Press 'n' for non-paying car" << endl;
    cout << "Press 'e' to exit and display total" << endl;

    // Infinite loop to handle user input
    while (true) {
        cout << "Enter your choice: ";
        cin >> choice;

        if (choice == 'p') {
            tollbooth.payingcar();
            cout << "Paying car recorded" << endl;
        } else if (choice == 'n') {
            tollbooth.nonpaycar();
            cout << "Non-paying car recorded" << endl;
        } else if (choice == 'e') {
            cout << "Exiting..." << endl;
            tollbooth.display(); // Display totals
            break;
        } else {
            cout << "Invalid input. Please try again." << endl;
        }
    }

    return 0;
}