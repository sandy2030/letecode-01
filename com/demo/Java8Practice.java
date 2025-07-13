package com.demo;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Practice {

    public static void main(String[] args) {
        String input = "programming";
        List<Map.Entry<String, Long>> collect = Arrays.stream(input.split("")).
                collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .collect(Collectors.toList());
            System.out.println("duplicate letters "+collect);
        // highest length word
        String str="I am learning JAVA Api";
        String s = Arrays.stream(str.split(" ")).max(Comparator.comparing(String::length)).get();
        System.out.println(s);
        // Print numbers from 1 to 10
        IntStream.rangeClosed(1,10).forEach(w-> System.out.print(w+" , "));
        System.out.println();
        int r=IntStream.rangeClosed(1,10).sum();
        System.out.println(r);
        int[] arr = {2, 2};
        int max = IntStream.of(arr).max().orElseThrow();
        System.out.println("max "+max);
        List<Integer> numbers = List.of(10, 20, 30, 40);
        double v = numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println(v);
        int[] ar = {5, 3, 3, 2, 1, 5};
        IntStream.of(ar).distinct().sorted().forEach(System.out::print);
        System.out.println();
        IntStream.rangeClosed(1,5).map(c->c*c).forEach(z-> System.out.print(z+" "));
        System.out.println();
        int[] a1 = {3, 7, 2, 9, 5}; // 2 3 5 7 9
        int i = IntStream.of(a1).distinct().sorted().skip(a1.length - 2).findFirst().orElseThrow();
        System.out.println(i);
        Integer integer = Arrays.stream(a1).distinct().boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("2nd highest "+integer);
        int num = 1234;
        int sum = String.valueOf(num).chars().map(Character::getNumericValue).sum();
        System.out.println("sum "+sum);

        int num1 = 112233;
        Map<Integer, Long> collect1 = String.valueOf(num1).chars().mapToObj(Character::getNumericValue).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect1);

        IntStream.iterate(2,x->x+2).limit(10).forEach(x-> System.out.print(x+" "));
        System.out.println();
        List<String> in = List.of("1", "2", "3");
        List<Integer> collect2 = in.stream().mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        System.out.println(collect2);

        long count = IntStream.rangeClosed(1, 10)
                .filter(n -> n % 3 == 0)
                .count();
        System.out.println("Count = " + count); // Output: 16

        int n = 17;
        boolean isPrime = IntStream.rangeClosed(2, n / 2)
                .noneMatch(p -> n % p == 0);
        System.out.println(n + " is prime? " + isPrime);
        boolean b = IntStream.rangeClosed(2, n / 2).noneMatch(k -> n % k == 0);
        System.out.println(b);
    }
}
