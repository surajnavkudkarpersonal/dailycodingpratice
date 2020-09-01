/**
This problem was asked by Google.
An XOR linked list is a more memory efficient doubly linked list. Instead of each node holding next and prev fields, it holds a field named both, which is an XOR of the next node and the previous node. Implement an XOR linked list; it has an add(element) which adds the element to the end, and a get(index) which returns the node at index.
If using a language that has no pointers (such as Python), you can assume you have access to get_pointer and dereference_pointer functions that converts between nodes and memory addresses.
**/


#include <iostream>
#include <bits/stdc++.h> 
#include <inttypes.h>
using namespace std;
class Node  
{  
    public: 
    int data;  
    Node* npx; 
};  

Node* XOR(Node *a, Node *b){
   return (Node*) ((uintptr_t) (a) ^ (uintptr_t) (b));  
}
void insertStart(Node **head, int data)  {
    
    Node *newNode = new Node();
    newNode->data=data;
    newNode->npx=*head;
    
    if(*head!=NULL){
        (*head)->npx= XOR(newNode,(*head)->npx);
    }
    *head=newNode;
}
void printListForward (Node *head)  
{  
    Node *curr = head;  
    Node *prev = NULL;  
    Node *next; 
    while (curr != NULL)   {
       cout<<curr->data<<" "; 
       next=XOR(prev,curr->npx);
       prev=curr;
       curr=next;
       
    }
}

void printListRev (Node *head)  
{  
    Node *curr = head;  
    Node *prev = NULL;  
    Node *next; 
    while (curr != NULL)   {
       cout<<curr->data<<" "; 
       next=XOR(prev,curr->npx);
       prev=curr;
       curr=next;
       
    }
}
