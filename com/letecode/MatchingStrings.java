package com.letecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MatchingStrings {
    public static void main(String[] args) {

        List<Long> list = count();
        list.forEach(s-> System.out.println(s));
    }
    static List<Long> count(){
        List<String> queries=new ArrayList<>();
        queries.add("aba");queries.add("xzxb");queries.add("ab");
        List<String> input=new ArrayList<>();
        input.add("aba");input.add("baba");input.add("aba");input.add("xzxb");
        Map<String, Long> map = queries.stream().collect(Collectors.toMap(
                Function.identity(), item -> input.stream().filter(item::equals).count()
        ));
        map.forEach((element,count)-> System.out.println(element+" , "+count));
        return map.values().stream().collect(Collectors.toList());
    }
}
