package com.learn.stream;
import java.util.function.Function;
import java.util.stream.Collectors;
public class UtilPractice {
    /*
    * nput: cat, rabbit,roosteer,Hippopotamus, pronghorn
output :{cat=0}, {rabbit=1},{roosteer=3}, {Hippopotamus = 2}, {pronghorn=3}
    * */
    public static void main(String[] args) {
        getCount("roosteer");
    }

    static void   getCount(String str){
        int size = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(c -> c.getValue() > 1)
                .collect(Collectors.toList())
                .size();
        System.out.println("count  "+size);
    }
}