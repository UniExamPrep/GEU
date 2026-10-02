#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int data;
    struct node *next;
} n;

// Function to create a new node
n* createnode(int data) {
    n *newnode;
    newnode = (n *)malloc(sizeof(n)); // Allocating memory for the new node
    if (newnode == NULL) {
        printf("Memory allocation failed\n");
        exit(1); // Exit if memory allocation fails
    }
    newnode->data = data;
    newnode->next = NULL;
    return newnode;
}

// Function to insert a node at the end of the list
n* insert(n* head, int value) {
    if (head == NULL) {
        // If the list is empty, create the first node
        head = createnode(value);
        return head;
    }
    
    n* temp = head;
    while (temp->next != NULL) {
        temp = temp->next; // Traverse to the last node
    }
    temp->next = createnode(value); // Insert the new node at the end
    return head;
}

int main() {
    n* p = NULL; // Initialize the head pointer to NULL

    p = insert(p, 11); // Insert the first node with value 11
    p = insert(p, 22); // Insert another node with value 22

    // Print the linked list
    n* temp = p;
    while (temp != NULL) {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }
    printf("NULL\n");

    return 0;
}