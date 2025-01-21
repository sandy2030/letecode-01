package com.learn.stream;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
*
*  find the duplicates in string using stream
* Steps:
Convert the string into a stream of characters.
Group the characters using Collectors.groupingBy().
Count the occurrences of each character using Collectors.counting().
Filter the characters that have more than one occurrence (duplicates).
Collect the duplicates.
*
* */
public class StreamOp {

    public static void main(String[] args) {
        String str = "Java is my programming language";
        Map<Character, Long> map = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(map);

        List<Character> collect = str.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isLetter)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        if (collect.size()>1)
            System.out.println(collect.get(1));
        else
            System.out.println("no repetitive char");
    }
}
