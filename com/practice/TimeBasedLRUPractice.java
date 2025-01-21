package com.practice;

import com.learn.SimpleTimeBasedCache;

import java.util.HashMap;
import java.util.Map;

public class TimeBasedLRUPractice <K,V>{
    class CacheItem{
        V value;
        long expiryTime;

        public CacheItem(V value, long expiryTime) {
            this.value = value;
            this.expiryTime = expiryTime;
        }
    }

    private Map<K,CacheItem> cache=new HashMap<>();

    void put(K key,V value,long expiryTime){
        long time=System.currentTimeMillis()+expiryTime;
        cache.put(key,new CacheItem(value,time));
    }

    V get(K key){
        CacheItem item=null;
        long currentTime = System.currentTimeMillis();
        if (cache.containsKey(key))
         item = cache.get(key);
        if (item!=null && currentTime<item.expiryTime){
            return item.value;
        }
        cache.remove(key);
        return null;
    }
    void cleanUp(){
        long currentTime=System.currentTimeMillis();
        cache.entrySet().removeIf(e->currentTime>e.getValue().expiryTime);
    }
    public static void main(String[] args) throws InterruptedException {
        TimeBasedLRUPractice<String, String> cache = new TimeBasedLRUPractice<>();

        cache.put("k1","v1",2000);
        cache.put("k2","v2",5000);
        System.out.println("before sleep");
        System.out.println(cache.get("k1"));
        System.out.println(cache.get("k2"));
        Thread.sleep(4900);

        System.out.println("after sleep");
        System.out.println(cache.get("k1"));
        System.out.println(cache.get("k2"));

    }
}
