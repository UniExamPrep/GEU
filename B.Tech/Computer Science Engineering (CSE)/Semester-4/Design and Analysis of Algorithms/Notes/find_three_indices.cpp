/*
Question: Finding Three Indices
Given a sorted array of integers, find three indices i, j, and k such that arr[i] + arr[j] = arr[k]. 
If multiple solutions exist, print any one of them. If no solution exists, print "No sequence found".

Input Format:
The first line contains number of test cases, T. For each test case, there will be two input lines. 
First line contains n (the size of array).
Second line contains n space-separated integers describing array.

Output Format:
The output will have T number of lines.
For each test case, output will be three space-separated integers i, j, k if a solution exists, otherwise "No sequence found".

Time Complexity: O(n²)
Space Complexity: O(1)
*/

#include <iostream>
using namespace std;

void findThreeIndices(int arr[], int n) {
    bool found = false;
    
    // For each k, try to find i and j
    for(int k = 2; k < n; k++) {
        int i = 0, j = k - 1;
        
        // Use two pointer technique to find i and j
        while(i < j) {
            if(arr[i] + arr[j] == arr[k]) {
                cout << i << ", " << j << ", " << k << endl;
                found = true;
                break;
            }
            else if(arr[i] + arr[j] < arr[k]) {
                i++;
            }
            else {
                j--;
            }
        }
        
        if(found) break;
    }
    
    if(!found) {
        cout << "No sequence found" << endl;
    }
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
        
        findThreeIndices(arr, n);
        
        delete[] arr;
    }
    
    return 0;
} 