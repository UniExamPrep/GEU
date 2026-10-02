#include <stdio.h>
#include <stdlib.h>

// Structure of a node in a singly linked list
struct Node {
    int data;
    struct Node* next;
};

// Function to create a new node
struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

// Function to detect a loop in the linked list
int detectLoop(struct Node* PTR) {
    struct Node *slow = PTR, *fast = PTR;

    // Traverse the linked list
    while (slow != NULL && fast != NULL && fast->next != NULL) {
        slow = slow->next;            // Move slow by 1 step
        fast = fast->next->next;      // Move fast by 2 steps

        // If slow and fast meet, a loop is detected
        if (slow == fast) {
            return 1;  // Loop found
        }
    }
    return 0;  // No loop found
}

// Function to add a node at the end of the list
void appendNode(struct Node** head_ref, int new_data) {
    struct Node* new_node = createNode(new_data);
    struct Node* last = *head_ref;
    
    if (*head_ref == NULL) {
        *head_ref = new_node;
        return;
    }
    
    while (last->next != NULL)
        last = last->next;
    
    last->next = new_node;
}

// Main function to test loop detection
int main() {
    struct Node* PTR = NULL;

    // Adding nodes to the linked list
    appendNode(&PTR, 10);
    appendNode(&PTR, 20);
    appendNode(&PTR, 30);
    appendNode(&PTR, 40);
    appendNode(&PTR, 50);

    // Creating a loop for testing (50 -> 20)
    PTR->next->next->next->next->next = PTR->next;  // Creates a loop (50 points to 20)

    if (detectLoop(PTR))
        printf("Loop detected in the linked list.\n");
    else
        printf("No loop in the linked list.\n");

    return 0;
}