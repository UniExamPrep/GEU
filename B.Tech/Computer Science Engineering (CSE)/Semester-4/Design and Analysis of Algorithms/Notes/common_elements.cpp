/*
Question: Common Elements in Two Sorted Arrays
Given two sorted integer arrays of size m and n, find list of elements which are common to both.
Input Format:
m (size of first array)
m space-separated integers (first array)
n (size of second array)
n space-separated integers (second array)

Output Format:
Space-separated list of common elements

Time Complexity: O(m + n)
Space Complexity: O(1)
*/

#include <iostream>
using namespace std;

void findCommonElements(int arr1[], int m, int arr2[], int n) {
    int i = 0, j = 0;
    bool found = false;
    
    // Use two-pointer technique to find common elements
    while(i < m && j < n) {
        if(arr1[i] == arr2[j]) {
            cout << arr1[i] << " ";
            found = true;
            i++;
            j++;
        }
        else if(arr1[i] < arr2[j]) {
            i++;
        }
        else {
            j++;
        }
    }
    
    if(!found) {
        cout << "No Common Elements";
    }
    cout << endl;
}

int main() {
    int m, n;
    
    // Read first array
    cin >> m;
    int* arr1 = new int[m];
    for(int i = 0; i < m; i++) {
        cin >> arr1[i];
    }
    
    // Read second array
    cin >> n;
    int* arr2 = new int[n];
    for(int i = 0; i < n; i++) {
        cin >> arr2[i];
    }
    
    findCommonElements(arr1, m, arr2, n);
    
    delete[] arr1;
    delete[] arr2;
    
    return 0;
} 