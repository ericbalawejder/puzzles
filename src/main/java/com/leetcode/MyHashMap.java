package com.leetcode;

public class MyHashMap {

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 2);
        System.out.println("1 -> " + map.get(1));
        map.put(1, 4);
        System.out.println("1 -> " + map.get(1));
        map.remove(1);
        System.out.println("1 -> " + map.get(1));
        System.out.println("5 -> " + map.get(5));
    }

    private final int SIZE = 10000;
    private final Entry[] entries;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        entries = new Entry[SIZE];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int bucket = key % SIZE;
        Entry entry = entries[bucket];

        if (entry == null) {
            entries[bucket] = new Entry(key, value);
        } else {
            while (entry.next != null && entry.key != key) {
                entry = entry.next;
            }

            if (entry.key == key) {
                entry.value = value;
            } else {
                entry.next = new Entry(key, value);
            }
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int key) {
        int bucket = key % SIZE;
        Entry entry = entries[bucket];
        while (entry != null) {
            if (entry.key == key) {
                return entry.value;
            }
            entry = entry.next;
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping
     * for the key
     */
    public void remove(int key) {
        int bucket = key % SIZE;
        Entry entry = entries[bucket];

        if (entry != null && entry.key == key) {
            entries[bucket] = entry.next;
            return;
        }

        Entry current = new Entry(0, 0);
        current.next = entry;

        while (current.next != null && current.next.key != key) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    private static final class Entry {
        int key;
        int value;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
