#include <iostream>
#include <vector>
#include <queue>
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
        adj[v][u] = w; // For undirected graph
    }

    int primMST() {
        vector<int> key(V, INT_MAX);
        vector<bool> mstSet(V, false);
        vector<int> parent(V, -1);

        // Start with vertex 0
        key[0] = 0;

        for (int count = 0; count < V-1; count++) {
            // Find vertex with minimum key value
            int u = -1;
            for (int v = 0; v < V; v++) {
                if (!mstSet[v] && (u == -1 || key[v] < key[u]))
                    u = v;
            }

            mstSet[u] = true;

            // Update key values of adjacent vertices
            for (int v = 0; v < V; v++) {
                if (adj[u][v] && !mstSet[v] && adj[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = adj[u][v];
                }
            }
        }

        // Calculate total weight
        int totalWeight = 0;
        for (int i = 1; i < V; i++)
            totalWeight += adj[i][parent[i]];

        return totalWeight;
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

    cout << "Minimum Spanning Weight: " << g.primMST() << endl;
    return 0;
} 