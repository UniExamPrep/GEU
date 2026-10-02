/*
Question: Selection Sort
Given an unsorted array of integers, sort the array using selection sort algorithm.
Count and print the number of comparisons and swaps made during sorting.

Input Format:
T (number of test cases)
For each test case:
n (size of array)
n space-separated integers

Output Format:
For each test case:
Sorted array
Number of comparisons
Number of swaps

Time Complexity: O(n²)
Space Complexity: O(1)
*/

#include <iostream>
using namespace std;

void selectionSort(int arr[], int n) {
    int comparisons = 0;
    int swaps = 0;
    
    for(int i = 0; i < n - 1; i++) {
        // Find the minimum element in unsorted array
        int min_idx = i;
        for(int j = i + 1; j < n; j++) {
            comparisons++;
            if(arr[j] < arr[min_idx]) {
                min_idx = j;
            }
        }
        
        // Swap the found minimum element with the first element
        if(min_idx != i) {
            swap(arr[min_idx], arr[i]);
            swaps++;
        }
    }
    
    // Print sorted array
    for(int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
    
    // Print statistics
    cout << "comparisons = " << comparisons << endl;
    cout << "swaps = " << swaps << endl;
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
        
        selectionSort(arr, n);
        
        delete[] arr;
    }
    
    return 0;
} 