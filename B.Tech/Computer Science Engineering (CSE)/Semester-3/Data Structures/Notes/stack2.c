#include<stdio.h>
#include<stdlib.h>

int *stack;
int top = -1;
int size = 10;  // Initial size of the stack

void pop() {
    if (top == -1) {
        printf("Underflow\n");
        return;
    }
    printf("Popped element: %d\n", stack[top]);
    top = top - 1;
}

void peek() {
    if (top == -1) {
        printf("Underflow\n");
        return;
    }
    printf("Top element: %d\n", stack[top]);
}

void push(int element) {
    if (top == size - 1) {
        printf("Overflow\n");
        printf("If you want to give a new size for the stack, press 1: ");
        int a;
        scanf("%d", &a);
        if (a == 1) {
            printf("Enter new size for the stack: ");
            int b;
            scanf("%d", &b);
            stack = realloc(stack, b * sizeof(int));
            size = b;
        } else {
            return;
        }
    }
    top = top + 1;
    stack[top] = element;
}

int main() {
    stack = (int*)malloc(sizeof(int) * size);

    while (1) {
        printf("\nWelcome to stack\n");
        printf("Press 1 to push\n");
        printf("Press 2 to pop\n");
        printf("Press 3 to peek\n");
        printf("Press 4 to exit\n");
        printf("Choice: ");
        int s = 0;
        scanf("%d", &s);
        switch (s) {
            case 1:
                printf("Enter the element: ");
                int element;
                scanf("%d", &element);
                push(element);
                break;
            case 2:
                pop();
                break;
            case 3:
                peek();
                break;  
            case 4:
                free(stack);  // Free allocated memory before exiting
                return 0;
            default:
                printf("Invalid choice. Please try again.\n");
                break;
        }
    }

    return 0;
}