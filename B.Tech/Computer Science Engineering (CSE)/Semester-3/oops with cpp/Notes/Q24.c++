// Construct a C++ program to demonstrate different
// methods of List, Vector and Map in STL (Standard
// Template Library).

#include <iostream>
#include <list>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

int main() {
    // Working with list
    list<int> myList;
    myList.push_back(10);
    myList.push_back(20);
    myList.push_back(30);
    myList.push_back(40);   // Add to the end
    myList.push_front(5);   // Add to the front
    myList.pop_back();      // Remove the last element
    myList.remove(20);      // Remove element by value

    cout << "\nList contents: ";
    for (list<int>::iterator it = myList.begin(); it != myList.end(); ++it)
        cout << *it << " ";
    cout << endl;

    // Working with vector
    vector<int> myVector;
    myVector.push_back(1);
    myVector.push_back(2);
    myVector.push_back(3);
    myVector.push_back(4);
    myVector.push_back(5);
    myVector.push_back(6);                   // Add to the end
    myVector.erase(myVector.begin() + 2);    // Remove the 3rd element
    sort(myVector.begin(), myVector.end(), greater<int>());  // Sort in descending order

    cout << "Vector contents: ";
    for (vector<int>::iterator it = myVector.begin(); it != myVector.end(); ++it)
        cout << *it << " ";
    cout << endl;

    // Working with map
    map<string, int> myMap;
    myMap["Alice"] = 25;  // Add key-value pairs
    myMap["Bob"] = 30;
    myMap["Eve"] = 22;
    myMap.erase("Bob");   // Remove key-value pair with key "Bob"

    cout << "Map contents: ";
    for (map<string, int>::iterator it = myMap.begin(); it != myMap.end(); ++it)
        cout << it->first << ": " << it->second << " ";
    cout << endl;

    return 0;
}