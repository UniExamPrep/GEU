/*
Question: Kth Smallest/Largest Element
Given an unsorted array of integers, find the kth smallest element in the array using QuickSelect algorithm.
Assume k is always valid (1 ≤ k ≤ array length).

Input Format:
T (number of test cases)
For each test case:
n (size of array)
n space-separated integers
k (position to find)

Output Format:
For each test case:
kth smallest element

Time Complexity: O(n) average, O(n²) worst case
Space Complexity: O(1)
*/

#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

// Function to swap two elements
void swap(int& a, int& b) {
    int temp = a;
    a = b;
    b = temp;
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
        if(arr[j] <= pivot) {
            i++;
            swap(arr[i], arr[j]);
        }
    }
    
    // Place pivot in correct position
    swap(arr[i + 1], arr[right]);
    
    return i + 1;
}

// QuickSelect function to find kth smallest element
int quickSelect(int arr[], int left, int right, int k) {
    if(left == right) {
        return arr[left];
    }
    
    int pi = partition(arr, left, right);
    
    // If pivot is at kth position
    if(pi == k - 1) {
        return arr[pi];
    }
    
    // If kth element is in left subarray
    if(pi > k - 1) {
        return quickSelect(arr, left, pi - 1, k);
    }
    
    // If kth element is in right subarray
    return quickSelect(arr, pi + 1, right, k);
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
        
        int k;
        cin >> k;
        
        // Find kth smallest element
        int result = quickSelect(arr, 0, n - 1, k);
        cout << result << endl;
        
        delete[] arr;
    }
    
    return 0;
} 