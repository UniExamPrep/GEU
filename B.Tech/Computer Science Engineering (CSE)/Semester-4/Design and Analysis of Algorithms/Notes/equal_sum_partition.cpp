#include <iostream>
#include <vector>
using namespace std;

class EqualSumPartition {
private:
    vector<int> arr;

    bool canPartition(int n, int sum) {
        // If sum is odd, cannot partition
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        vector<bool> dp(target + 1, false);
        dp[0] = true;  // Base case: empty set

        // For each number
        for (int i = 0; i < n; i++) {
            // For each sum from target down to arr[i]
            for (int j = target; j >= arr[i]; j--) {
                dp[j] = dp[j] || dp[j - arr[i]];
            }
        }

        return dp[target];
    }

public:
    void addNumber(int num) {
        arr.push_back(num);
    }

    bool canPartition() {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return canPartition(arr.size(), sum);
    }
};

int main() {
    int n;
    cout << "Enter number of elements: ";
    cin >> n;

    EqualSumPartition esp;
    
    cout << "Enter elements: ";
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        esp.addNumber(num);
    }

    cout << (esp.canPartition() ? "Yes" : "No") << endl;
    return 0;
} 