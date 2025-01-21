package com.learn;
public class LinkedList {
    Node head;
    public LinkedList() {
        head=null;
    }
    void add(int data){
    Node newNode=new Node(data);
    if (head==null)
        head=newNode;
    else {
        Node temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }

    }

    void preappend(int data){
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
    }
 void  print() {
     if (head == null){
         System.out.println("list is empty");
         return;
 }
     Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
 }

 void reverse(){
        Node previous=null;
     Node current=head;
     Node next=null;
     // 1 - 2 - 3 -  4
     while (current!=null){
         next=current.next;
         current.next=previous;
         previous=current;
         current=next;
     }
head=previous;
 }

 void reverse1(){
        Node prev=null,next=null;
        Node current=head;
        // 1 2 3 4
        while (current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }

 }
    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.print();
        System.out.println("after preappend");
        list.preappend(4);
        list.print();
        list.reverse();
        System.out.println("after reverse");
        list.print();
    }
}

class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}