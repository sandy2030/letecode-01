package com.learn.stream;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CgTest {
    public static void main(String[] args) {
        List<String> list= Arrays.asList();
        String str="ilovejavatechie";

        List<Map.Entry<String, Long>> collect = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .collect(Collectors.toList());
        System.out.println(collect);
List<List<Integer>> lists=Arrays.asList(
        Arrays.asList(1,2,3),
        Arrays.asList(4,5,6),
        Arrays.asList(7,8,9)
);
        List<Integer> list1 = lists.stream().flatMap(s -> s.stream())
                .toList();
        System.out.println(list1);
    }
}
