package com.learn;

import java.util.HashMap;
import java.util.Map;
public class LRUBack {
    class Node{
        int key,value;
        Node prev,next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    Map<Integer,Node> map=new HashMap<>();
    Node head=new Node(0,0);
    Node tail=new Node(0,0);
    int capacity;

    public LRUBack( int capacity) {
        this.capacity = capacity;
        this.head.next=tail;
        this.tail.prev=head;
    }

    int get (int key){
        if (map.containsKey(key)){
            Node node=map.get(key);
            remove(node); // remove from current position
            add(node); // add next to head
            return node.value;
        }else{
            return -1;
        }
    }

    void put(int k,int v){
        if (map.containsKey(k))
            remove(map.get(k));
            if (map.size()==capacity)
                remove(tail.prev);
        add(new Node(k,v));
    }
    void add(Node node){
        map.put(node.key,node);
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
        node.prev=head;

    }
    void remove(Node node){
        map.remove(node.key);
        Node before=node.prev;
        Node after=node.next;
        before.next=after;
        after.prev=before;
    }
    public static void main(String[] args) {
        LRUBack cache=new LRUBack(4);
        cache.put(1,10);
        cache.put(2,20);
        cache.put(3,30);
        cache.put(4,40);
        // 40 30 20 10
        System.out.println(cache.get(1));
        // 10 40 30 20
        cache.put(5,50); // 50 10 40 30
        System.out.println(cache.get(2)); // -1
        cache.put(7,70); // 70 50 10 40
        System.out.println(cache.get(3)); // -1
    }
}
