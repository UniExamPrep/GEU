#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class ArrayAnalyzer {
private:
    vector<int> arr;

    int findMajorityElement() {
        int count = 1;
        int candidate = arr[0];

        // Boyer-Moore Voting Algorithm
        for (int i = 1; i < arr.size(); i++) {
            if (count == 0) {
                candidate = arr[i];
                count = 1;
            } else if (arr[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Verify if candidate is majority element
        count = 0;
        for (int num : arr) {
            if (num == candidate) count++;
        }

        return (count > arr.size()/2) ? candidate : -1;
    }

    double findMedian() {
        int n = arr.size();
        sort(arr.begin(), arr.end());
        
        if (n % 2 == 0) {
            return (arr[n/2 - 1] + arr[n/2]) / 2.0;
        } else {
            return arr[n/2];
        }
    }

public:
    void addElement(int num) {
        arr.push_back(num);
    }

    void analyze() {
        int majority = findMajorityElement();
        double median = findMedian();

        cout << (majority != -1 ? "yes" : "no") << endl;
        cout << median << endl;
    }
};

int main() {
    int n;
    cout << "Enter size of array: ";
    cin >> n;

    ArrayAnalyzer analyzer;
    
    cout << "Enter array elements: ";
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        analyzer.addElement(num);
    }

    analyzer.analyze();
    return 0;
} 