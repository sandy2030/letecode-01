package com.demo
        ;

public class Demo {
    public static void main(String[] args) {
        Operation1  add=(int i,int j)->{
            return i+j;
        };

        int calculate = add.calculate(1, 2);
        System.out.println(calculate);
    }
}

interface Operation1{
    int calculate(int a,int b);
}