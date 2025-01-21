package com.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupByExample {
    public static void main(String[] args) {
        //groupByDemo();
        //partitioningByDemo();
        //groupByUniqueElements();
        countChar();
    }

    static void countChar(){
        String input = "Java is my programming language";
        LinkedHashMap<String, Long> map = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println(map);
        List<String> list = map.entrySet().stream().filter(s -> s.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        //System.out.println(list);
        if (list.size()>=2)
            System.out.println(list.get(2));
        else
            System.out.println("not enough chars");

    }
    static void groupByUniqueElements(){
        List<Person> personList=getPersonList();
        Map<Integer, Set<Person>> collect = personList.stream().collect(Collectors.groupingBy(p -> p.getAge(), Collectors.toSet()));
        collect.forEach((age,personSet)->{
            System.out.println("Age "+age+"   "+personSet);
        });
    }
    static void partitioningByDemo(){
        Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<String> stream = Stream.of("1", "2", "3");
        /*Map<Boolean, List<Integer>> collect = intStream.collect(Collectors.partitioningBy(x -> x > 3));
        System.out.println(collect);*/
        intStream.collect(
                Collectors.partitioningBy(
                x->(x>3), Collectors.counting()));
    }
    static void groupByDemo(){
        List<Person> personList=getPersonList();
        Map<Integer, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(Person::getAge));
        collect.forEach((age,personList1) -> {
            System.out.println("Age "+age+personList1);
        });
    }
    static List<Person> getPersonList(){
        Person p1=new Person(40,"ram");
        Person p2=new Person(42,"shyam");
        Person p3=new Person(25,"shani");
        Person p4=new Person(25,"rahu");
        Person p5=new Person(35,"ketu");
        Person p6=new Person(35,"chandra");
        Person p7=new Person(36,"chandra");
        List<Person> personList= Arrays.asList(p1,p2,p3,p4,p5,p6,p7);
        return personList;
    }
}
