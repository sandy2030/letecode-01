package com.learn.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByExample {
    public static void main(String[] args) {
        System.out.println("hi");
        List<Person> list=getPersons();
        Map<Integer, List<Person>> map = list.stream()
                .collect(Collectors.groupingBy(Person::getAge));
        map.values().forEach(s->s.stream().filter(x->x.getAge()>25 && x.getAge()<=30 && x.getGender().equals("male"))
                .forEach(x-> System.out.println(x)));
    }
    static List<Person> getPersons(){
        return Arrays.asList(new Person(26,"ADMIN","Peter","male"),
                new Person(30,"IT","Sharly","female"),
                new Person(43,"IT","Rohit","male"),
                new Person(29,"SALSE","Ramya","male"));
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
