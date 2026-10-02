#include <iostream>
#include <algorithm>
using namespace std;

int countPairsWithDifference(int arr[], int n, int k) {
    int count = 0;
    
    // Sort the array
    sort(arr, arr + n);
    
    // Use two pointer technique
    int left = 0, right = 1;
    
    while(right < n) {
        int diff = arr[right] - arr[left];
        
        if(diff == k) {
            count++;
            left++;
            right++;
        }
        else if(diff < k) {
            right++;
        }
        else {
            left++;
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
        
        cout << countPairsWithDifference(arr, n, k) << endl;
        
        delete[] arr;
    }
    
    return 0;
} 