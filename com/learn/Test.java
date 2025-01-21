package com.learn;

import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(1,2);
        map.put(1,3);
        map.entrySet().stream().forEach(k-> System.out.print("key: "+k.getKey()+" val: "+k.getValue()));

        Singleton singleton=Singleton.getInstamce();
        try {
            Singleton cloneObj=(Singleton) singleton.clone();
            System.out.println(singleton.hashCode()+"---"+cloneObj.hashCode());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}