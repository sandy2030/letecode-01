package com.learn;

import java.util.HashMap;
import java.util.Map;
public class LRUCache {
  class Node{
    int key,value;
    Node prev,next;
    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
  Map<Integer,Node> map=new HashMap<>();
  Node head=new Node(0,0), tail=new Node(0,0);
  int capacity;

  public LRUCache( int capacity) {
    this.capacity = capacity;
    this.head.next = tail;
    this.tail.prev = head;
  }

  public  int get(int key)
  {
    if (map.containsKey(key)){
      Node node=map.get(key);
      remove(node);
      add(node);
      return node.value;
    }else
      return -1;
  }
///// h    1    2   3   t

  public void  put(int k,int v){
    if (map.containsKey(k))
      remove(map.get(k));
    if (map.size()==capacity)
      remove(tail.prev);
    add(new Node(k,v));
  }

  private void remove(Node node) {
      map.remove(node.key);
      node.prev.next=node.next;
      node.next.prev=node.prev;
  }

  ////   h  --n-- 1   2   3    4   5   t
  // Adds a node right after the head.
  //
  private void add(Node node){
      map.put(node.key, node);
      node.next=head.next;
      head.next.prev=node;
      node.prev=head;
      head.next=node;
  }
  public static void main(String[] args) {
    LRUCache lruCache = new LRUCache(2);
    lruCache.put(1, 1);
    lruCache.put(2, 2);
    System.out.println(lruCache.get(1)); // returns 1
    lruCache.put(3, 3); // evicts key 2
    System.out.println(lruCache.get(2)); // returns -1 (not found)
    lruCache.put(4, 4); // evicts key 1
    System.out.println(lruCache.get(1)); // returns -1 (not found)
    System.out.println(lruCache.get(3)); // returns 3
    System.out.println(lruCache.get(4)); // returns 4
  }
}