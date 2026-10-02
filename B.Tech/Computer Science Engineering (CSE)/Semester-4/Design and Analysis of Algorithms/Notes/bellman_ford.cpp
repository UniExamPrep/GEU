#include <iostream>
#include <vector>
#include <climits>
using namespace std;

class Graph {
private:
    int V;
    vector<vector<pair<int, int>>> adj;

public:
    Graph(int vertices) {
        V = vertices;
        adj.resize(V);
    }

    void addEdge(int u, int v, int w) {
        adj[u].push_back({v, w});
    }

    void bellmanFord(int src) {
        vector<int> dist(V, INT_MAX);
        vector<int> parent(V, -1);
        dist[src] = 0;

        // Relax all edges V-1 times
        for (int i = 1; i <= V-1; i++) {
            for (int u = 0; u < V; u++) {
                for (auto& edge : adj[u]) {
                    int v = edge.first;
                    int weight = edge.second;

                    if (dist[u] != INT_MAX && dist[v] > dist[u] + weight) {
                        dist[v] = dist[u] + weight;
                        parent[v] = u;
                    }
                }
            }
        }

        // Check for negative weight cycles
        for (int u = 0; u < V; u++) {
            for (auto& edge : adj[u]) {
                int v = edge.first;
                int weight = edge.second;

                if (dist[u] != INT_MAX && dist[v] > dist[u] + weight) {
                    cout << "Graph contains negative weight cycle\n";
                    return;
                }
            }
        }

        // Print paths
        for (int i = 0; i < V; i++) {
            if (i != src) {
                cout << i << " : ";
                vector<int> path;
                for (int v = i; v != -1; v = parent[v])
                    path.push_back(v);
                
                for (int j = path.size() - 1; j >= 0; j--) {
                    cout << path[j];
                    if (j > 0) cout << " ";
                }
                cout << " : " << dist[i] << endl;
            }
        }
    }
};

int main() {
    int V, E;
    cout << "Enter number of vertices and edges: ";
    cin >> V >> E;

    Graph g(V);
    
    cout << "Enter edges (source destination weight):\n";
    for (int i = 0; i < E; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        g.addEdge(u, v, w);
    }

    int src;
    cout << "Enter source vertex: ";
    cin >> src;

    g.bellmanFord(src);
    return 0;
} 