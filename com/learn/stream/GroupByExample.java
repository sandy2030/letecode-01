package com.learn.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GroupByExample {
    public static void main(String[] args) {
        List<Person> list=getPersons();
        m1();
        Stream<Person> personStream = list.stream().sorted(Comparator.comparingInt(Person::getAge).reversed());
        //System.out.println("max age "+person.getAge());
        Person person = personStream.skip(1).findFirst().orElse(null);
        System.out.println("2nd age  "+person.getAge());
        Stream<String> limit = Stream.generate(() -> "new streams ").limit(4);
        limit.forEach(s-> System.out.print(s+"  ,  "));
        Stream.generate(()->1).limit(2).forEach(x-> System.out.print(x+" "));
        System.out.println();
        Stream.iterate(0,a->a+2).limit(4).forEach(z-> System.out.print(z));
        IntStream.range(1,4).forEach(s-> System.out.println("range   "+s));
        List<Integer>intList=Arrays.asList(1,23,5,2, 6,7,8,6,23);
        Optional<Integer> reduce = intList.stream().reduce((a, b) -> (a + b));
        System.out.println(reduce.get());
        double asDouble = intList.stream().mapToInt(x -> x).average().getAsDouble();
        System.out.println(asDouble);
        double asDouble1 = intList.stream().map(a -> a * a).mapToInt(z -> z).average().getAsDouble();
        System.out.println(asDouble1);
        List<Integer> collect = intList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(collect);
        List<Integer> collect1 = intList.stream().map(s -> String.valueOf(s)).filter(e -> e.startsWith("2")).map(Integer::valueOf).collect(Collectors.toList());
        System.out.println(collect1);
        Set<Integer> collect2 = intList.stream().filter(e -> Collections.frequency(intList, e) > 1).collect(Collectors.toSet());
        System.out.println(collect2);
        Set<Integer>set=new HashSet<>();
        List<Integer> collect3 = intList.stream().filter(e -> !set.add(e)).collect(Collectors.toList());
        System.out.println(collect3);
        Integer integer = intList.stream().max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println(integer);
    }
    static List<Person> getPersons(){
        return Arrays.asList(new Person(26,"ADMIN","Peter","male"),
                new Person(30,"IT","Sharly","female"),
                new Person(43,"IT","Rohit","male"),
                new Person(29,"SALSE","Ramya","male"));
    }
    static void m1(){
        List<Person> list=getPersons();
        Map<Integer, List<Person>> map = list.stream()
                .collect(Collectors.groupingBy(Person::getAge));
        // get male employees between age of 25 and 30
        map.values().forEach(s->s.stream().filter(x->x.getAge()>25 && x.getAge()<=30 && x.getGender().equals("male"))
                .forEach(x-> System.out.println(x)));
    }
}


class Person{
    int age;
    String dept;
    String  name;

    String  gender;

    public Person(int age, String dept, String name, String gender) {
        this.age = age;
        this.dept = dept;
        this.name = name;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public String getDept() {
        return dept;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", dept='" + dept + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
