/*
Question: Quick Sort
Given an unsorted array of integers, sort the array using quick sort algorithm with random pivot selection.
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

Time Complexity: O(n log n) average, O(n²) worst case
Space Complexity: O(log n)
*/

#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

// Global counters
int comparisons = 0;
int swaps = 0;

// Function to swap two elements
void swap(int& a, int& b) {
    int temp = a;
    a = b;
    b = temp;
    swaps++;
}

// Function to generate random pivot
int randomPivot(int left, int right) {
    return left + rand() % (right - left + 1);
}

// Partition function
int partition(int arr[], int left, int right) {
    // Choose random pivot
    int pivotIndex = randomPivot(left, right);
    int pivot = arr[pivotIndex];
    
    // Move pivot to end
    swap(arr[pivotIndex], arr[right]);
    
    int i = left - 1;
    
    // Partition around pivot
    for(int j = left; j < right; j++) {
        comparisons++;
        if(arr[j] <= pivot) {
            i++;
            swap(arr[i], arr[j]);
        }
    }
    
    // Place pivot in correct position
    swap(arr[i + 1], arr[right]);
    
    return i + 1;
}

// Quick sort function
void quickSort(int arr[], int left, int right) {
    if(left < right) {
        int pi = partition(arr, left, right);
        quickSort(arr, left, pi - 1);
        quickSort(arr, pi + 1, right);
    }
}

int main() {
    // Initialize random seed
    srand(time(0));
    
    int t;
    cin >> t;
    
    while(t--) {
        int n;
        cin >> n;
        
        int* arr = new int[n];
        for(int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        
        // Reset counters
        comparisons = 0;
        swaps = 0;
        
        // Sort array
        quickSort(arr, 0, n - 1);
        
        // Print sorted array
        for(int i = 0; i < n; i++) {
            cout << arr[i] << " ";
        }
        cout << endl;
        
        // Print statistics
        cout << "comparisons = " << comparisons << endl;
        cout << "swaps = " << swaps << endl;
        
        delete[] arr;
    }
    
    return 0;
} 