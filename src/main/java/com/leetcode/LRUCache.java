package com.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        cache.put(1, 2);
        cache.put(2, 3);
        cache.put(3, 5);
        cache.put(4, 7);
        cache.put(5, 11);
        System.out.println(cache);
        cache.put(6, 13);
        System.out.println(cache);
        cache.put(7, 17);
        System.out.println(cache);
        cache.put(8, 18);
        System.out.println(cache);
    }

    private Map<Integer, Integer> map;

    LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity, 1, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    int get(int key) {
        Integer value = map.get(key);
        if (value == null) {
            return -1;
        }
        return value;
    }

    void put(int key, int value) {
        map.put(key, value);
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
