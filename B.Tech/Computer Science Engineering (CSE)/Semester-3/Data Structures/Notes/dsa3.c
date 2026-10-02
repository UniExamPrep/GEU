#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    struct Node *pre;
    int data;
    struct Node *next;
} Node;

Node *head = NULL;

Node* insert(Node* head, int value) {
    Node* ptr = (Node*)malloc(sizeof(Node));
    if (ptr == NULL) {
        printf("Memory allocation failed\n");
        return head;
    }
    ptr->data = value;
    ptr->next = head;
    ptr->pre = NULL;

    if (head != NULL) {
        head->pre = ptr;
    }
    
    head = ptr;
    return head;
}

Node* delete_key(Node* head, int key) {
    if (head == NULL) {
        printf("Underflow: List is empty\n");
        return NULL;
    }
    
    Node* curr = head;

    while (curr != NULL && curr->data != key) {
        curr = curr->next;
    }

    if (curr == NULL) {
        printf("Key %d not found\n", key);
        return head;
    }

    if (curr == head) {
        head = head->next;
        if (head != NULL) {
            head->pre = NULL;
        }
        free(curr);
        return head;
    }

    if (curr->pre != NULL) {
        curr->pre->next = curr->next;
    }
    if (curr->next != NULL) {
        curr->next->pre = curr->pre;
    }
    
    free(curr);
    return head;
}

void display(Node* head) {
    Node* curr = head;
    while (curr != NULL) {
        printf("%d ", curr->data);
        curr = curr->next;
    }
    printf("\n");
}

int main() {
    int choice, value;

    while (1) {
        printf("1. Insert\n2. Delete by key\n3. Display\n4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter Data: ");
                scanf("%d", &value);
                head = insert(head, value);
                break;
            case 2:
                printf("Enter key to delete: ");
                scanf("%d", &value);
                head = delete_key(head, value);
                break;
            case 3:
                display(head);
                break;
            case 4:
                exit(0);
            default:
                printf("Invalid choice\n");
        }
    }

    return 0;
}