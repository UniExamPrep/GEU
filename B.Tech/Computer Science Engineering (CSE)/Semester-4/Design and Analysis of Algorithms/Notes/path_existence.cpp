#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class Graph {
private:
    int V;
    vector<vector<int>> adj;

public:
    Graph(int vertices) {
        V = vertices;
        adj.resize(V);
    }

    void addEdge(int u, int v) {
        adj[u].push_back(v);
        adj[v].push_back(u); // For undirected graph
    }

    bool DFSUtil(int v, int dest, vector<bool>& visited) {
        if (v == dest) return true;
        visited[v] = true;

        for (int u : adj[v]) {
            if (!visited[u]) {
                if (DFSUtil(u, dest, visited)) return true;
            }
        }
        return false;
    }

    bool pathExists(int src, int dest) {
        vector<bool> visited(V, false);
        return DFSUtil(src, dest, visited);
    }
};

int main() {
    int V, E;
    cout << "Enter number of vertices and edges: ";
    cin >> V >> E;

    Graph g(V);
    
    cout << "Enter edges (source destination):\n";
    for (int i = 0; i < E; i++) {
        int u, v;
        cin >> u >> v;
        g.addEdge(u, v);
    }

    int src, dest;
    cout << "Enter source and destination vertices: ";
    cin >> src >> dest;

    if (g.pathExists(src, dest))
        cout << "Yes Path Exists\n";
    else
        cout << "No Such Path Exists\n";

    return 0;
} 