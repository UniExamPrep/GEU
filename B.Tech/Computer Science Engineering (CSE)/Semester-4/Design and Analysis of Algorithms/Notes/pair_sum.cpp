/*
Question: Pair Sum Problem
Given an unsorted array of integers, find whether two elements exist such that their sum is equal to the given key element.
Input Format:
T (number of test cases)
For each test case:
n (size of array)
n space-separated integers
key (sum to find)

Output Format:
For each test case:
"element1 element2" if pair exists
"No Such Elements Exist" if no pair found

Time Complexity: O(n log n)
Space Complexity: O(1)
*/

#include <iostream>
#include <algorithm>
using namespace std;

void findPairSum(int arr[], int n, int target) {
    // Sort the array
    sort(arr, arr + n);
    
    bool found = false;
    
    // Use two pointer technique
    int left = 0, right = n - 1;
    
    while(left < right) {
        int sum = arr[left] + arr[right];
        
        if(sum == target) {
            cout << arr[left] << " " << arr[right] << endl;
            found = true;
            left++;
            right--;
        }
        else if(sum < target) {
            left++;
        }
        else {
            right--;
        }
    }
    
    if(!found) {
        cout << "No Such Elements Exist" << endl;
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
        
        int target;
        cin >> target;
        
        findPairSum(arr, n, target);
        
        delete[] arr;
    }
    
    return 0;
} 