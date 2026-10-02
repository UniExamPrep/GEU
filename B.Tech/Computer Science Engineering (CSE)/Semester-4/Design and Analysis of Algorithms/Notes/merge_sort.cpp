/*
Question: Merge Sort
Given an unsorted array of integers, sort the array using merge sort algorithm.
Count and print the number of comparisons and inversions made during sorting.

Input Format:
T (number of test cases)
For each test case:
n (size of array)
n space-separated integers

Output Format:
For each test case:
Sorted array
Number of comparisons
Number of inversions

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

#include <iostream>
using namespace std;

// Global counters
int comparisons = 0;
int inversions = 0;

void merge(int arr[], int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;
    
    // Create temporary arrays
    int* L = new int[n1];
    int* R = new int[n2];
    
    // Copy data to temporary arrays
    for(int i = 0; i < n1; i++)
        L[i] = arr[left + i];
    for(int j = 0; j < n2; j++)
        R[j] = arr[mid + 1 + j];
    
    // Merge the temporary arrays back into arr
    int i = 0, j = 0, k = left;
    while(i < n1 && j < n2) {
        comparisons++;
        if(L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        }
        else {
            arr[k] = R[j];
            j++;
            inversions += (n1 - i);  // Count inversions
        }
        k++;
    }
    
    // Copy remaining elements of L[]
    while(i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }
    
    // Copy remaining elements of R[]
    while(j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
    
    // Free temporary arrays
    delete[] L;
    delete[] R;
}

void mergeSort(int arr[], int left, int right) {
    if(left < right) {
        int mid = left + (right - left) / 2;
        
        // Sort first and second halves
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        
        merge(arr, left, mid, right);
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
        
        // Reset counters
        comparisons = 0;
        inversions = 0;
        
        // Sort array
        mergeSort(arr, 0, n - 1);
        
        // Print sorted array
        for(int i = 0; i < n; i++) {
            cout << arr[i] << " ";
        }
        cout << endl;
        
        // Print statistics
        cout << "comparisons = " << comparisons << endl;
        cout << "inversions = " << inversions << endl;
        
        delete[] arr;
    }
    
    return 0;
} 