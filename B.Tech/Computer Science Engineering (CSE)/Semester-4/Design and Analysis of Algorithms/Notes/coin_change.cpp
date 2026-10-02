#include <iostream>
#include <vector>
using namespace std;

class CoinChange {
private:
    vector<int> coins;

    int countWays(int n) {
        vector<int> dp(n + 1, 0);
        dp[0] = 1;  // Base case: empty set

        // For each coin
        for (int coin : coins) {
            // For each sum from coin to n
            for (int i = coin; i <= n; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[n];
    }

public:
    void addCoin(int value) {
        coins.push_back(value);
    }

    int getWays(int sum) {
        return countWays(sum);
    }
};

int main() {
    int n;
    cout << "Enter number of coins: ";
    cin >> n;

    CoinChange cc;
    
    cout << "Enter coin values: ";
    for (int i = 0; i < n; i++) {
        int value;
        cin >> value;
        cc.addCoin(value);
    }

    int sum;
    cout << "Enter target sum: ";
    cin >> sum;

    cout << cc.getWays(sum) << endl;
    return 0;
} 