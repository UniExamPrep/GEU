#include<stdio.h>
#include<stdlib.h>

typedef struct node {
    int data;
    struct node* next;
} Node;

Node* head = NULL;

Node* insert(Node* head, int value) {
    Node* ptr = (Node*)malloc(sizeof(Node));
    if (ptr == NULL) {
        printf("Memory allocation failed\n");
        return head;
    }
    ptr->data = value;
    ptr->next = head;
    head = ptr;
    return head;
}

Node* delete(Node* head) {
    if (head == NULL) {
        printf("Underflow\n");
        return head;
    }
    Node* temp = head;
    head = head->next;
    free(temp);
    return head;
}

void displayHead(Node* head) {
    if (head == NULL) {
        printf("Stack is empty\n");
    } else {
        printf("Top element is: %d\n", head->data);
    }
}

int main() {
    while (1) {
        printf("Welcome to stack\n");
        printf("Press 1 to insert\n");
        printf("Press 2 to delete\n");
        printf("Press 3 to display the head element\n");
        printf("Press 4 to exit\n");
        
        int s = 0;
        scanf("%d", &s);
        
        switch (s) {
            case 1:
                printf("Enter the Element: ");
                int element;
                scanf("%d", &element);
                head = insert(head, element);
                break;
            case 2:
                head = delete(head);
                break;
            case 3:
                displayHead(head);
                break;
            case 4:
                exit(0);
                break;
            default:
                printf("Invalid choice! Please try again.\n");
                break;
        }
    }
    return 0;
}