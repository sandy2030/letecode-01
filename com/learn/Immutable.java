package com.learn;

public class Immutable {

    private final String name;
    private final int age;

    public Immutable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getMutableName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}