#include<stdio.h>
#include<stdlib.h>

typedef struct node {
    int data;
    struct node *next;
} node;

node *front = NULL; // Initialize front and rear as NULL
node *rear = NULL;

void enqueue(int val) {
    node *nn = (node*)malloc(sizeof(node)); // Allocate memory for the new node
    if (nn == NULL) {
        printf("Memory allocation failed\n");
        return;
    }
    nn->data = val; // Set the data for the new node
    nn->next = NULL; // New node's next should be NULL

    if (rear == NULL) { // If the queue is empty
        front = rear = nn; // Both front and rear point to the new node
    } else {
        rear->next = nn; // Add the new node to the end of the queue
        rear = nn; // Update the rear to the new node
    }
}

void dequeue() {
    if (front == NULL) { // If the queue is empty
        printf("Queue is empty, nothing to dequeue.\n");
        return;
    }
    
    node *temp = front; // Store the front node temporarily
    front = front->next; // Move the front pointer to the next node
    
    if (front == NULL) { // If the queue becomes empty after dequeuing
        rear = NULL; // Set rear to NULL as well
    }
    
    printf("Dequeued: %d\n", temp->data);
    free(temp); // Free the memory of the dequeued node
}

void display() {
    node *temp = front;
    while (temp != NULL) {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }
    printf("NULL\n");
}

int main() {
    enqueue(10);
    enqueue(20);
    enqueue(30);

    printf("Queue before dequeue:\n");
    display(); // This will print: 10 -> 20 -> 30 -> NULL

    dequeue(); // Dequeue the first element
    dequeue(); // Dequeue the next element

    printf("Queue after dequeue:\n");
    display(); // This will print the remaining elements

    return 0;
}