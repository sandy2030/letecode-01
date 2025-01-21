package com.test12;

public class Demo {
    public static void main(String[] args) {
            I1 i1 =(frm, to) -> {
                System.out.println("I1 report created");
            };

            I2 i2=(frm, to) -> {
                System.out.println("I2 report created");
            };

            I3 i3=(frm, to) -> {
                System.out.println("I3 report created");
            };
    }
}

@FunctionalInterface
interface  I1{
    void  createReport(String frm,String to);
}

interface I2{
    void  createReport(String frm,String to);
}


interface I3{
    void  createReport(String frm,String to);
}