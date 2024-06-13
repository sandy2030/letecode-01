package com.java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Java8Example {

    public static void main(String[] args) {
        // consumer
        Consumer<String> consumer=s-> System.out.println(s);        //  void accept(T t);
        consumer.accept("aa");
        // predicate
        Predicate<Integer> isEven=s->s%2==0;        // boolean test(T t);
        System.out.println(isEven.test(12));
        // supplier
        Supplier<String> greet= ()-> "ss";  // T get();

        System.out.println(greet.get());

        Function<Integer,String> converter=x->Integer.toString(x);      //  R apply(T t);
        System.out.println(converter.apply(123));

        Function<Integer,Integer> mutiplyBy2=x->x*2;
        Function<Integer,Integer> add3=y->y+3;
        System.out.println("add3    "+add3.apply(3));
        System.out.println("mutiplyBy2    "+mutiplyBy2.apply(3));
        Function<Integer, Integer> compose = add3.compose(mutiplyBy2);
        System.out.println(compose.apply(3));




    }
}
