#include <iostream>
#include <vector>
#include <queue>
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
        adj[v].push_back({u, w}); // For undirected graph
    }

    void dijkstra(int src) {
        vector<int> dist(V, INT_MAX);
        vector<int> parent(V, -1);
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

        dist[src] = 0;
        pq.push({0, src});

        while (!pq.empty()) {
            int u = pq.top().second;
            pq.pop();

            for (auto& edge : adj[u]) {
                int v = edge.first;
                int weight = edge.second;

                if (dist[v] > dist[u] + weight) {
                    dist[v] = dist[u] + weight;
                    parent[v] = u;
                    pq.push({dist[v], v});
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

    g.dijkstra(src);
    return 0;
} 