package com.interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple", "banana", "kiwi");

         /*words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String,Long>comparingByValue().reversed())
                .forEach(e-> System.out.println(e.getKey()+"  "+e.getValue()));*/
        //.forEach((k,v)-> System.out.print(k+" repeating  "+v+" times \n"));
        /*words.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting())) // returns map
                .forEach((k,v)-> System.out.println(k+"  "+v));*/
words.stream()
        .sorted()
        .forEach(s-> System.out.println(s));

        Person p1=new Person("John",10);
        Person p2=new Person("Mack",73);
        Person p3=new Person("Bret",44);
        List<Person> list=Arrays.asList(p1,p2,p3);
       /* list.stream()
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .forEach(p-> System.out.println(p.getName()+" "+p.getAge()));*/

        // using compare(p1,p2) of comparator
        list.stream()
                .sorted((s1,s2)->s2.getAge()-s1.getAge())
                .forEach(s-> System.out.println(s.getName()+"  ---  "+s.getAge()));

    }

}
 class Person{
    String name;
    int  age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

     @Override
     public java.lang.String toString() {
         return "Person{" +
                 "name=" + name +
                 ", age=" + age +
                 '}';
     }

 }