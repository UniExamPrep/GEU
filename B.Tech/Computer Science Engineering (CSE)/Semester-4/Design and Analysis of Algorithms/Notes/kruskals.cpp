#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Edge {
public:
    int src, dest, weight;
    Edge(int s, int d, int w) : src(s), dest(d), weight(w) {}
};

class Graph {
private:
    int V;
    vector<Edge> edges;

    int find(vector<int>& parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    void Union(vector<int>& parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

public:
    Graph(int vertices) {
        V = vertices;
    }

    void addEdge(int u, int v, int w) {
        edges.push_back(Edge(u, v, w));
    }

    int kruskalMST() {
        // Sort edges by weight
        sort(edges.begin(), edges.end(), 
            [](const Edge& a, const Edge& b) {
                return a.weight < b.weight;
            });

        vector<int> parent(V, -1);
        int totalWeight = 0;
        int edgeCount = 0;

        for (const Edge& edge : edges) {
            int x = find(parent, edge.src);
            int y = find(parent, edge.dest);

            if (x != y) {
                totalWeight += edge.weight;
                Union(parent, x, y);
                edgeCount++;
            }

            if (edgeCount == V-1)
                break;
        }

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

    cout << "Minimum Spanning Weight: " << g.kruskalMST() << endl;
    return 0;
} 