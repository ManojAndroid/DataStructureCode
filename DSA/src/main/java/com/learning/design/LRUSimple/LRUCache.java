package com.learning.design.LRUSimple;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>(2);
        lruCache.put(1, "One");
        lruCache.put(2, "Two");

        System.out.println(lruCache.get(1)); // Output: One
        lruCache.put(3, "Three");

        System.out.println(lruCache.get(2)); // Output: null (evicted)

    }
}
