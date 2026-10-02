/*
Question: Counting Pairs with Given Difference
Given an array of integers and a difference value k, count the number of pairs of integers in the array that have a difference of k.
Each element can be used in at most one pair.

Input Format:
T (number of test cases)
For each test case:
n (size of array)
k (difference value)
n space-separated integers

Output Format:
For each test case:
Number of pairs with difference k

Time Complexity: O(n log n)
Space Complexity: O(1)
*/

#include <iostream>
#include <algorithm>
using namespace std;

int countPairs(int arr[], int n, int k) {
    // Sort the array
    sort(arr, arr + n);
    
    int count = 0;
    int i = 0, j = 1;
    
    // Use two pointer technique
    while(j < n) {
        int diff = arr[j] - arr[i];
        
        if(diff == k) {
            count++;
            i++;
            j++;
        }
        else if(diff < k) {
            j++;
        }
        else {
            i++;
        }
    }
    
    return count;
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
        
        int k;
        cin >> k;
        
        cout << countPairs(arr, n, k) << endl;
        
        delete[] arr;
    }
    
    return 0;
} 