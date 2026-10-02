#include <stdio.h>
#include <stdlib.h>
struct node {
    int data;
    struct node *next;
};
int main(){
    struct node *head=malloc(sizeof(struct node));
    head->data=45;
    head->next=NULL;
    struct node *current=malloc(sizeof(struct node));
    scanf("%d",&current->data);
    current->next=NULL;
    head->next=current;
    current=malloc(sizeof(struct node));
    current->data=7;
    current->next=NULL;
    head->next->next=current;
}