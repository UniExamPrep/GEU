#include <iostream>
#include <vector>
#include <climits>
using namespace std;

class Graph {
private:
    int V;
    vector<vector<int>> dist;

public:
    Graph(int vertices) {
        V = vertices;
        dist.resize(V, vector<int>(V, INT_MAX));
        for (int i = 0; i < V; i++)
            dist[i][i] = 0;
    }

    void addEdge(int u, int v, int w) {
        dist[u][v] = w;
    }

    void floydWarshall() {
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INT_MAX && dist[k][j] != INT_MAX &&
                        dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print the shortest distance matrix
        cout << "Shortest Distance Matrix:\n";
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INT_MAX)
                    cout << "INF ";
                else
                    cout << dist[i][j] << " ";
            }
            cout << endl;
        }
    }
};

int main() {
    int V;
    cout << "Enter number of vertices: ";
    cin >> V;

    Graph g(V);
    
    cout << "Enter adjacency matrix (use INT_MAX for no edge):\n";
    for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {
            int w;
            cin >> w;
            if (w != INT_MAX) g.addEdge(i, j, w);
        }
    }

    g.floydWarshall();
    return 0;
} 