package com.interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practice {

    public static void main(String[] args) {

        String str="java programming";

        Map<String, Long> map = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
        ////////
        List<String> list = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(list);
        ////////////
        /* find first non repeat element from string*/
        List<String> list1 = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                   .stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        if (list1.size()>=2)
            System.out.println("2nd non repeatitive char "+list1.get(1));
        /////////////////////
        int []arr={12,2,21,-1,0,37,29};
        Integer integer = Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst()
                .get();
        //System.out.println(integer);
        ///////////////////////////////
        String[] strArray={"a","asasasa","qwqwqwqwqwqwqw","qwqwq","hhjjhjgjgjgjghjgjgjgjgjgjgjg"};
        String s = Arrays.stream(strArray)
                .reduce((w1, w2) -> w1.length() > w2.length() ? w1 : w2)
                .get();
        System.out.println("s:  "+s);
        ///////////////////////////
        int a1[]={21,11,01,00,11,123,911};
        List<String> list2 = Arrays.stream(a1)
                .boxed()
                .map(q -> q + "")
                .filter(z->z.startsWith("1"))
                .collect(Collectors.toList());
        System.out.println(list2);
    }
}
