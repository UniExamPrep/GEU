/*
Question: Maximum Occurring Alphabet
Given an unsorted array of alphabets containing duplicate elements, find which alphabet has maximum number of occurrences and print it.
Input Format:
T (number of test cases)
For each test case:
n (size of array)
n space-separated alphabets

Output Format:
For each test case:
"alphabet - count" if duplicates exist
"No Duplicates Present" if no duplicates

Time Complexity: O(n)
Space Complexity: O(1)
*/

#include <iostream>
#include <cstring>
using namespace std;

void findMaxOccurringAlphabet(char arr[], int n) {
    // Create count array for 26 alphabets
    int count[26] = {0};
    
    // Count frequency of each alphabet
    for(int i = 0; i < n; i++) {
        if(arr[i] >= 'a' && arr[i] <= 'z') {
            count[arr[i] - 'a']++;
        }
    }
    
    // Find maximum occurring alphabet
    int maxCount = 0;
    char maxChar = '\0';
    bool hasDuplicates = false;
    
    for(int i = 0; i < 26; i++) {
        if(count[i] > 1) {  // Check for duplicates
            hasDuplicates = true;
            if(count[i] > maxCount) {
                maxCount = count[i];
                maxChar = 'a' + i;
            }
        }
    }
    
    // Print result
    if(hasDuplicates) {
        cout << maxChar << " - " << maxCount << endl;
    } else {
        cout << "No Duplicates Present" << endl;
    }
}

int main() {
    int t;
    cin >> t;
    
    while(t--) {
        int n;
        cin >> n;
        
        char* arr = new char[n];
        for(int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        
        findMaxOccurringAlphabet(arr, n);
        
        delete[] arr;
    }
    
    return 0;
} 