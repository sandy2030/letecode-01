package com.learn;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import  java.util.*;

public class Solution {

    public static void main(String[] args) {
        /*String s="Java is my programming language";
        List<IntStream> collect = Stream.of(s).map(String::chars).distinct().collect(Collectors.toList());
        Stream<String> s1 = Stream.of(s);
        List<IntStream> collect1 = s1.map(String::chars).collect(Collectors.toList());
        System.out.println(collect1);
        //System.out.println(collect.toString());
        //collect(Collectors.filtering())
        Stream<IntStream> intStreamStream = Stream.of(s).map(String::chars);

        collect.forEach(a-> System.out.println(a));*/
        String input = "Java is my programming language";

        // Convert the string to a list of characters (ignoring spaces)
        List<Character> charList = input.replaceAll("\\s", "")
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        Map<Character, Long> map = charList.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
        System.out.println("map is   "+map); //  {a=5, e=1, g=4, i=2, J=1, l=1, m=3, n=2, o=1, p=1, r=2, s=1, u=1, v=1, y=1}

        LinkedHashMap<Character, Long> collect = charList.stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,
                        Collectors.counting()));
        System.out.println("collect is   "+collect);
        // Count the frequency of each character using Collectors.groupingBy and Collectors.counting
        List<Character> nonRepetitiveChars = charList.stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,
                        Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)  // Filter out characters that appear more than once
                .map(Map.Entry::getKey)  // Get the character
                .collect(Collectors.toList()); // Collect non-repetitive characters

        // Check if we have at least two non-repetitive characters
        if (nonRepetitiveChars.size() >= 2) {
            System.out.println("Second non-repetitive character: " + nonRepetitiveChars.get(1));
        } else {
            System.out.println("There are not enough non-repetitive characters in the string.");
        }
    }
}
