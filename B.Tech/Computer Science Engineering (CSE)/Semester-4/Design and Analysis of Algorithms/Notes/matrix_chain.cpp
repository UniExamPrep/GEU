#include <iostream>
#include <vector>
#include <climits>
using namespace std;

class MatrixChain {
private:
    vector<pair<int, int>> dimensions;

    int matrixChainOrder() {
        int n = dimensions.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));

        // Length of chain
        for (int len = 2; len <= n; len++) {
            // Starting index of chain
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = INT_MAX;

                // Try all possible splits
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k+1][j] + 
                              dimensions[i].first * dimensions[k].second * dimensions[j].second;
                    dp[i][j] = min(dp[i][j], cost);
                }
            }
        }

        return dp[0][n-1];
    }

public:
    void addMatrix(int rows, int cols) {
        dimensions.push_back({rows, cols});
    }

    int getMinOperations() {
        return matrixChainOrder();
    }
};

int main() {
    int n;
    cout << "Enter number of matrices: ";
    cin >> n;

    MatrixChain chain;
    
    cout << "Enter dimensions of each matrix (rows cols):\n";
    for (int i = 0; i < n; i++) {
        int rows, cols;
        cin >> rows >> cols;
        chain.addMatrix(rows, cols);
    }

    cout << chain.getMinOperations() << endl;
    return 0;
} 