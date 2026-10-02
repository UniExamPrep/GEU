#include <iostream>
#include <vector>
using namespace std;

class Graph {
private:
    int V;
    vector<vector<int>> adj;

    bool DFSUtil(int v, vector<bool>& visited, vector<bool>& recStack) {
        visited[v] = true;
        recStack[v] = true;

        for (int u : adj[v]) {
            if (!visited[u]) {
                if (DFSUtil(u, visited, recStack))
                    return true;
            }
            else if (recStack[u])
                return true;
        }

        recStack[v] = false;
        return false;
    }

public:
    Graph(int vertices) {
        V = vertices;
        adj.resize(V);
    }

    void addEdge(int u, int v) {
        adj[u].push_back(v);
    }

    bool hasCycle() {
        vector<bool> visited(V, false);
        vector<bool> recStack(V, false);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (DFSUtil(i, visited, recStack))
                    return true;
            }
        }
        return false;
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

    if (g.hasCycle())
        cout << "Yes Cycle Exists\n";
    else
        cout << "No Cycle Exists\n";

    return 0;
} 