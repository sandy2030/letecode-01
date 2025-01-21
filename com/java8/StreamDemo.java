package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        //consumerDemo();
        //supplierDemo();

        FunctionDemo();
    }

    private static void FunctionDemo() {
        List<String> list = Arrays.asList("sas", "wqwqqw", "assasa", "kjkj");
        Function<String,Integer> inputLengh=String::length;
        List<Integer> collect = list.stream().map(inputLengh).collect(Collectors.toList());
        System.out.println("lenghth   "+collect);
    }

    private static   void supplierDemo() {
        class Expensive{
            Expensive(){
                System.out.println("Expensive object is being created ... ");
            }
            @Override
            public String toString() {
                return "Expensive object instance ";
            }
        }
        Supplier<Expensive> supplier=()->new Expensive(); // Supplier created, but object is not initialized yet
        Expensive expensive = supplier.get();//  object is created only when get() is called
        System.out.println("object created  ---->>>>>   "+expensive);
    }

    static void consumerDemo(){
        Consumer<String> print=input-> System.out.print("print= "+input);

        Consumer<String> length=input-> System.out.print("  length= "+input.length());

        Consumer<String> result=print.andThen(length);

        result.accept("sandeep");
    }
}
