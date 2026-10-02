#include<stdio.h>
#include<stdlib.h>
int *stack;
stack=(int*)malloc(sizeof(int)*10);
int top=-1;
void pop(){
    if (top==-1){
        printf("underflow");
        return;
    }
    top =top -1;
    return;
}
void peek(){
    if (top==-1){
        printf("underflow");
        return;
    }
    printf("%d",stack[top]);
    return;
}
void push(int element){
    if (top==10){
        printf("overflow");
        printf("If you want to Give New size of Stack Press 1");
        int a;
        scanf("%d",&a);
        if(a==1){
        printf("Enter New Size for Stack");
        int b;
        scanf("%d",&b);
        stack=realloc(stack,b*sizeof(int));
        }
        else

        return;
    }
    top =top +1;
    stack[top]=element;
    return;


}

int main(){
    while (1){
    printf("welcome to stack\n");
    printf("press 1 to push\n");
    printf("press 2 to pop\n");
    printf("press 3 to peek\n");
    printf("Thanks");
    int s=0;
    scanf("%d",&s);
    switch (s)
    {
    case 1:
        printf("Enter the Element");
        int element;
        scanf("%d",&element);
        push(element);
        break;
    case 2:
        pop();
        break;
    case 3:
        printf("Element:-\n");
        peek();
        break;  
    
    default:
        break;
    }
}
return 0;
}