// The task is to debug the existing code to successfully
// execute all provided test files. You are required to extend
// the existing code so that it handles the
// std::invalid_argument exception properly. More
// specifically, you have to extend the implementation of
// the process_input function. It takes integer n as an
// argument and has to work as follows:
// • It calls function largest_proper_divisor(n).
// • If this call returns a value without raising an
// exception, it should print in a single line result = d
// where d is the returned value.
// • Otherwise, if the call raises an invalid_argument
// exception, it has to print in a single line the string
// representation of the raised exception, i.e., its
// message.
// • Finally, no matter if the exception is raised or not, it
// should print in a single line returning control flow to
// the caller after any other previously printed output.
// Input Format: The input is read by the provided locked
// code template. In the only line of the input, there is a
// single integer n, which is going to be the argument passed
// to function process input.
// Sample Input: 0
// Sample Output: The largest proper divisor is not defined
// for n = 0, returning control flow to the caller
// Sample Input: 0
// Sample Output: result=3

#include <iostream>
#include <stdexcept>
using namespace std;

// Function to find the largest proper divisor of a number
int largest_proper_divisor(int n) {
    if (n == 0) 
        throw invalid_argument("The largest proper divisor is not defined for n = 0");
    if (n == 1) 
        throw invalid_argument("The largest proper divisor is not defined for n = 1");
    
    for (int i = n / 2; i >= 1; --i) {
        if (n % i == 0) 
            return i;
    }
    return -1; // This line is unreachable but added for completeness
}

// Function to process input and handle exceptions
void process_input(int n) {
    try {
        int d = largest_proper_divisor(n);
        cout << "result = " << d << endl;
    } catch (const std::invalid_argument& e) {
        // Handle the exception and print the error message
        cout << e.what() << endl;
    }
    cout << "Returning control flow to the Caller..." << endl;
}

int main() {
    int n;
    // Read user input
    cin >> n;
    // Process the input
    process_input(n);
    return 0;
}