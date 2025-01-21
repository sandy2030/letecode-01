package com.practice;

import java.util.HashMap;
import java.util.Map;

public class LRUPractice {
    class Node{
        int key,value;
        Node prev,next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    private Map<Integer,Node> map=new HashMap<>();
    Node head,tail;

    public LRUPractice(int capacity) {
        this.capacity = capacity;
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }

    void put(int k,int v){
        if(map.containsKey(k)){
            Node node=map.get(k);
             remove(node);
             if (map.size()==capacity){
                 remove(tail.prev);
             }
        }
        insert(new Node(k,v));
    }

    int get(int k){
        if(map.containsKey(k)){
            Node node=map.get(k);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }


    private void insert(Node node) {
            map.put(node.key,node);
            node.next=head.next;
            head.next.prev=node;
            node.prev=head;
            head.next=node;
    }

    //
    //     h    2    3  4  t
    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
void  print(){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.key+" -- >");
            temp=temp.next;
        }
}
    public static void main(String[] args) {
        LRUPractice obj = new LRUPractice(5);
        System.out.println("before");
    obj.print();
        System.out.println();
        int param_1 = obj.get(2);
        System.out.println("param_1: "+param_1);
        obj.put(2,3);
        System.out.println("after");
        obj.print();
        System.out.println();
        System.out.println("value   "+obj.get(2));
        obj.print();
    }
}
