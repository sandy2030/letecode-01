package com.test1;

import java.util.*;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        int arr[]={7,10,11,5,2,5,5,7,11,8,9};
        int k=4;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }else{
                map.put(arr[i],map.get(arr[i])+1);
            }
        }
        System.out.println("map "+map);
        /*Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Integer key=iterator.next().getKey();
            Integer value=iterator.next().getValue();
        }*/


        List<Integer> collect = map.entrySet().stream().filter(x -> x.getValue() > 1).map(Map.Entry::getValue)
                .sorted(Comparator.reverseOrder())
                .limit(4)
                .collect(Collectors.toList());
        System.out.println("list "+collect);




    }
}
