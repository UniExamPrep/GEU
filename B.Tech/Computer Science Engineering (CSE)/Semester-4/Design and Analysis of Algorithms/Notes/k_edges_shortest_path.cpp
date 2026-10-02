#include <iostream>
#include <vector>
#include <climits>
using namespace std;

class Graph {
private:
    int V;
    vector<vector<int>> adj;

public:
    Graph(int vertices) {
        V = vertices;
        adj.resize(V, vector<int>(V, 0));
    }

    void addEdge(int u, int v, int w) {
        adj[u][v] = w;
    }

    int shortestPathKEdges(int src, int dest, int k) {
        // dp[i][j][k] represents shortest path from i to j with exactly k edges
        vector<vector<vector<int>>> dp(V, vector<vector<int>>(V, vector<int>(k+1, INT_MAX)));

        // Base case: 0 edges
        for (int i = 0; i < V; i++)
            dp[i][i][0] = 0;

        // Fill dp table
        for (int e = 1; e <= k; e++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    for (int m = 0; m < V; m++) {
                        if (adj[i][m] != 0 && dp[m][j][e-1] != INT_MAX) {
                            dp[i][j][e] = min(dp[i][j][e], adj[i][m] + dp[m][j][e-1]);
                        }
                    }
                }
            }
        }

        return dp[src][dest][k];
    }
};

int main() {
    int V;
    cout << "Enter number of vertices: ";
    cin >> V;

    Graph g(V);
    
    cout << "Enter adjacency matrix:\n";
    for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {
            int w;
            cin >> w;
            if (w != 0) g.addEdge(i, j, w);
        }
    }

    int src, dest, k;
    cout << "Enter source and destination vertices: ";
    cin >> src >> dest;
    cout << "Enter number of edges k: ";
    cin >> k;

    int result = g.shortestPathKEdges(src, dest, k);
    
    if (result == INT_MAX)
        cout << "no path of length k is available\n";
    else
        cout << "Weight of shortest path from (" << src << "," << dest << ") with " << k << " edges : " << result << endl;

    return 0;
} 