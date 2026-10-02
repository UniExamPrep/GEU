/*
Question: Duplicate Detection
Given an unsorted array of integers, check if the array contains any duplicate elements.
Print "YES" if duplicates exist, "NO" otherwise.

Input Format:
T (number of test cases)
For each test case:
n (size of array)
n space-separated integers

Output Format:
For each test case:
"YES" if duplicates exist
"NO" if no duplicates

Time Complexity: O(n log n)
Space Complexity: O(1)
*/

#include <iostream>
#include <algorithm>
using namespace std;

bool hasDuplicates(int arr[], int n) {
    // Sort the array
    sort(arr, arr + n);
    
    // Check for duplicates
    for(int i = 0; i < n - 1; i++) {
        if(arr[i] == arr[i + 1]) {
            return true;
        }
    }
    
    return false;
}

int main() {
    int t;
    cin >> t;
    
    while(t--) {
        int n;
        cin >> n;
        
        int* arr = new int[n];
        for(int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        
        if(hasDuplicates(arr, n)) {
            cout << "YES" << endl;
        }
        else {
            cout << "NO" << endl;
        }
        
        delete[] arr;
    }
    
    return 0;
} 