/*
Question: Insertion Sort
Given an unsorted array of integers, sort the array using insertion sort algorithm.
Count and print the number of comparisons and shifts made during sorting.

Input Format:
T (number of test cases)
For each test case:
n (size of array)
n space-separated integers

Output Format:
For each test case:
Sorted array
Number of comparisons
Number of shifts

Time Complexity: O(n²)
Space Complexity: O(1)
*/

#include <iostream>
using namespace std;

void insertionSort(int arr[], int n) {
    int comparisons = 0;
    int shifts = 0;
    
    for(int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;
        
        // Move elements that are greater than key
        // to one position ahead of their current position
        while(j >= 0) {
            comparisons++;
            if(arr[j] > key) {
                arr[j + 1] = arr[j];
                shifts++;
                j--;
            }
            else {
                break;
            }
        }
        
        arr[j + 1] = key;
    }
    
    // Print sorted array
    for(int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
    
    // Print statistics
    cout << "comparisons = " << comparisons << endl;
    cout << "shifts = " << shifts << endl;
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
        
        insertionSort(arr, n);
        
        delete[] arr;
    }
    
    return 0;
} 