package com.java8;

import java.util.Objects;

public class Person {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        if(name==null){
           if (person.name!=null)
               return false;
        }else if (!name.equals(person.name))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
