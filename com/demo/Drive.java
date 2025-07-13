package com.demo;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Drive {
    public static void main(String[] args) {
     // 1
            String str="i am learning java stream API from an institute";
        String s = Arrays.stream(str.split(" ")).max(Comparator.comparing(String::length)).get();
        System.out.println(s);
     //2
     String str1="dabcadefg";//dabcefg
        str1.chars().distinct().mapToObj(c->(char)c).forEach(q-> System.out.print(q));
        System.out.println();
        Arrays.stream(str1.split("")).distinct().forEach(x-> System.out.print(x));
        System.out.println();
        String s1 = Arrays.stream(str.split(" ")).
                sorted(Comparator.comparing(String::length).reversed()).skip(2)
                .findFirst().get();
        System.out.println("->> "+s1);

        Integer integer = Arrays.stream(str.split(" ")).map(x -> x.length()).
                sorted(Comparator.reverseOrder()).skip(0).findFirst()
                .get();
        System.out.println("inte ---> "+integer);
    //find the occurrence of each word
        //{java=1, stream=1, i=1, institute=1, from=1, API=1, learning=1, am=1, an=1}
        // {i=1, am=1, learning=1, java=1, stream=1, API=1, from=1, an=1, institute=1}
        Map<String, Long> collect = Arrays.stream(str.split(" ")).
                collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()));
        System.out.println(collect);

        //find the words with a specified number of vowels
        List<String> list = Arrays.stream(str.split(" ")).
                filter(x -> x.replaceAll("[^aeiouAEIOU]", "").length() == 2)
                .collect(Collectors.toList());
        System.out.println("vowel list "+list);

        int arr[] ={1,2,3,4,5,6,7,8};

        List<Integer> list2 = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println("list2   "+list2);
        List<List<Integer>> collect1 = list2.stream().
                collect(Collectors.groupingBy(x -> x % 2 == 0, Collectors.toList()))
                .entrySet()
                .stream()
                .map(x -> x.getValue()).collect(Collectors.toList());
        System.out.println("collect1   "+collect1);
        Map<Boolean, List<Integer>> collect2 = list2.stream().
                collect(Collectors.groupingBy(x -> x % 2 == 0, Collectors.toList()));
        System.out.println("collect2    "+collect2);
    //find the occurrence of each character
        String s2="Mississippi";
        List<Map.Entry<String, Long>> collect3 = Arrays.stream(s2.split(""))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toList());
        System.out.println("collect3   "+collect3); //collect3   [p=2, s=4, i=4, M=1]   collect3   [M=1, i=4, s=4, p=2]
    int are[]={112,2,3,4,5};
    Arrays.stream(are).mapToObj(x->x).sorted(Collections.reverseOrder()).forEach(x-> System.out.print(x+" "));

    }
}
