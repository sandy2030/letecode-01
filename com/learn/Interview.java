package com.learn;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Interview {

    static void findNonRepetitiveChar(){
        String str="java programming";
        LinkedHashMap<String, Long> collect1 = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println(collect1);
        List<String> collect = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        if (collect.size()>=2)
            System.out.println(collect.get(1));
    }

    static void maxSum(int[]arr){
        // 12  3  0  -1  23   -4
        OptionalInt max = Arrays.stream(arr).max();
        System.out.println(max.getAsInt());
        int sum = Arrays
                .stream(arr)
                .boxed()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("sum  "+sum);
    }
    public static void main(String[] args) {
                findNonRepetitiveChar();
                //int arr[]={23,12 ,3, 0 ,-1, 23, -4};
            //maxSum(arr);
    }
}
