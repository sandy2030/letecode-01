package com.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

public class MixProbs {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,3,4,5,5);
        list.stream()
                .filter(i -> Collections.frequency(list, i) > 1)
                .collect(Collectors.toSet())
                .forEach(s-> System.out.print(s+" , "));


    }
}
