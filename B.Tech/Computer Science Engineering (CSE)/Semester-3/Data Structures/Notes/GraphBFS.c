#include <stdio.h>
#include <stdlib.h>

#define MAX 100

int queue[MAX], front = -1, rear = -1;
int adj[MAX][MAX], visited[MAX];
int n; // Number of vertices in the graph

void enqueue(int vertex) {
    if (rear == MAX - 1) {
        printf("Queue Overflow\n");
        return;
    }
    if (front == -1)
        front = 0;
    queue[++rear] = vertex;
}

int dequeue() {
    if (front == -1 || front > rear) {
        printf("Queue Underflow\n");
        return -1;
    }
    return queue[front++];
}

int isQueueEmpty() {
    return front == -1 || front > rear;
}

void BFS(int startVertex) {
    int i, currentVertex;
    enqueue(startVertex);
    visited[startVertex] = 1;

    while (!isQueueEmpty()) {
        currentVertex = dequeue();
        printf("%d ", currentVertex);

        for (i = 0; i < n; i++) {
            if (adj[currentVertex][i] == 1 && !visited[i]) {
                enqueue(i);
                visited[i] = 1;
            }
        }
    }
}

int main() {
    int i, j, startVertex;

    printf("Enter the number of vertices: ");
    scanf("%d", &n);

    if (n <= 0) {
        printf("The graph must have at least one vertex.\n");
        return 1;
    }

    printf("Enter the adjacency matrix:\n");
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            scanf("%d", &adj[i][j]);
        }
    }

    for (i = 0; i < n; i++) {
        visited[i] = 0;
    }

    printf("Enter the starting vertex: ");
    scanf("%d", &startVertex);

    if (startVertex < 0 || startVertex >= n) {
        printf("Invalid starting vertex.\n");
        return 1;
    }

    printf("Breadth First Search starting from vertex %d:\n", startVertex);
    BFS(startVertex);

    return 0;
}