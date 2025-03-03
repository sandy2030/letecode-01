package com.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Example {

    public static void main(String[] args) {
        List<Student> list;
        String[]arr;
        //list.stream().filter(x->x.getName().)
        int a=1;
        int b=15;
        a=b-a;//
        b=b-a;//
        a=b+a;

        System.out.println("a "+a+" b "+b);
        List<String> records = Arrays.asList("apple", "banana", "cherry", "date");
        String[] validValues = {"apple", "cherry", "date"};
        records.stream().filter(x -> Arrays.asList(validValues).contains(x)).
                collect(Collectors.toList()).forEach(c-> System.out.println(c));


        List<String> list1 = Arrays.asList("1", "2", "a", "3");
        list1.stream().map(x->{
            try {
                return Integer.parseInt(x);
            }catch (NumberFormatException w){
                System.out.println("invalid number "+w);
                return null;
            }
        }).filter(Objects::nonNull)
                .forEach(System.out::println);

    }
}


class Student{
    Integer id;
    String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}