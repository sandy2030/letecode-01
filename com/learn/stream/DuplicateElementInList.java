package com.learn.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateElementInList {

    static void  findDuplicate(List<String> list){
        Set<String> unique=new HashSet<>();
        List<String> collect = list.stream().filter(x -> !unique.add(x)).collect(Collectors.toList());
        collect.forEach(x-> System.out.print(x+" ,"));

    }
    public static void main(String[] args) {
        List<String> list= Arrays.asList("a","b","c","d","a","b");
        findDuplicate(list);
    }
}
