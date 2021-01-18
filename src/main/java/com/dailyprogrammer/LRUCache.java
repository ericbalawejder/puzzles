package com.dailyprogrammer;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private final class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{key=" + key + " : value=" + value + "}";
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        System.out.println(cache.get(3));
        cache.put(1, 2);
        cache.put(2, 3);
        cache.put(3, 5);
        cache.put(4, 7);
        cache.put(5, 11);
        System.out.println(cache);
        cache.put(6, 13);
        System.out.println(cache);
    }

    int capacity;
    Map<Integer, Node> map;
    Node first;
    Node last;

    LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        first = new Node(0,0);
        last = new Node(0,0);

        first.next = last;
        last.prev = first;
    }

    int get(int key) {
        Node node = map.get(key);
        if(node == null) {
            return -1;
        }
        remove(node);
        insert(node);

        return node.value;
    }

    void put(int key, int value) {
        if(map.containsKey(key)) {
            remove(map.get(key));
        }
        if(map.size() == capacity) {
            remove(last.prev);
        }
        insert(new Node(key, value));
    }

    void insert(Node node){
        map.put(node.key, node);
        node.next = first.next;
        first.next.prev = node;
        first.next = node;
        node.prev = first;
    }

    void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
