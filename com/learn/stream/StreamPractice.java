package com.learn.stream;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamPractice {
    public static void main(String[] args) {
        String str = "Java is my programming language";
        /*Map<String, Long> collect = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));*/

        String key = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() == 1)
                .findFirst().get().getKey();
                /*.map(Map.Entry::getKey)
                .collect(Collectors.toList());*/
        //System.out.println(collect);
        List<Character> collect = str.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isLetter)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("key "+collect);
    }
}
