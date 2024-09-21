package com.learn;

import java.util.*;

public class SimpleTimeBasedCache<K, V> {

    private class CacheItem {
        V value;
        long expirationTime;

        public CacheItem(V value, long expirationTime) {
            this.value = value;
            this.expirationTime = expirationTime;
        }
    }

    private final Map<K, CacheItem> cacheMap = new HashMap<>();

    // Put item in the cache with TTL (Time to Live)
    public void put(K key, V value, long ttlInMillis) {
        long expirationTime = System.currentTimeMillis() + ttlInMillis;
        cacheMap.put(key, new CacheItem(value, expirationTime));
    }

    // Get item from the cache if it hasn't expired
    public V get(K key) {
        CacheItem item = cacheMap.get(key);
        if (item != null && System.currentTimeMillis() < item.expirationTime) {
            return item.value; // Cache hit
        }
        cacheMap.remove(key); // Remove expired item
        return null; // Cache miss
    }

    // Clean expired items from the cache
    public void cleanUp() {
        long currentTime = System.currentTimeMillis();
        cacheMap.entrySet().removeIf(entry -> currentTime > entry.getValue().expirationTime);
    }

    // Example usage
    public static void main(String[] args) throws InterruptedException {
        SimpleTimeBasedCache<String, String> cache = new SimpleTimeBasedCache<>();

        cache.put("key1", "value1", 2000);
        cache.put("key2", "value2", 5000); // Cache for 5 seconds

        System.out.println("key1: " + cache.get("key1")); // Should print value1
        System.out.println("key2: " + cache.get("key2")); // Should print value2

        Thread.sleep(3000); // Wait 3 seconds
        cache.cleanUp(); // Clean expired items

        System.out.println("key1 after 3 seconds: " + cache.get("key1")); // Should print null (expired)
        System.out.println("key2 after 3 seconds: " + cache.get("key2")); //
    }
}
