package com.test;

import java.util.*;
import java.util.stream.Collectors;

public class Practice {

    static void getStrings(List<String> list){
        // aa bb cc
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i< list.size();i++){
                if(map.containsKey(list.get(i))) {
                    map.put(list.get(i),map.get(list.get(i))+1);
                }else {
                    map.put(list.get(i),1);
                }
        }
        List<Map.Entry<String, Integer>> collect = map.entrySet().stream().collect(Collectors.toList());
        System.out.println(collect);
        //collect.stream().sorted(Comparator.reverseOrder())

        for (int i=0;i<collect.size();i++){
            Map.Entry<String, Integer> entry = collect.get(i);
            Integer value = entry.getValue();

        }

    }
    public static void main(String[] args) {
            List<String> list= Arrays.asList("a","b","c","a","b","d","a","b","e");
        getStrings(list);
    }

}
