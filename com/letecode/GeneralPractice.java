package com.letecode;

import java.util.*;
import java.util.stream.Collectors;

public class GeneralPractice {
    void callMe(String str){
        System.out.println("callMe with string "+str);
    }

    void callMe(Object obj){
        System.out.println("callMe with object "+obj.toString());
    }

    void callMe(Integer in){
        System.out.println("callMe with integer "+in);
    }
    public static void main(String[] args) {
        int a=1;
        int b=2;
        a=a+b; // 3
        b=a-b; // 1
        a=a-b; // 2
        Integer []ar={1,2,3,4,5,6};
        int sum = Arrays.stream(ar).filter(x -> x % 2 != 0).mapToInt(x -> x.intValue()).sum();
        System.out.println(sum);
        m();

    }
    static void m(){
        List<String> list = Arrays.asList("apple", "banana", "kiwi", "plum", "orange");
        String s = list.stream().sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println("s:   "+s);


        String d = list.stream()
                .min(Comparator.comparingInt(String::length))
                .get();
        System.out.println("s  "+d);

        Integer len = list.stream()
                .map(String::length)
                .min(Integer::compare)
                .get();
        System.out.println("len  "+len);
    }

}
