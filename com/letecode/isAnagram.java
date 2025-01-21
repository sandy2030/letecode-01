package com.letecode;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class isAnagram {
    private static boolean isAnagram(String s,String t){
        Map<Character,Integer> map=new HashMap<>();
        if (s.length()!=t.length())
            return false;
         boolean flag=true;
        for (int i=0;i<s.length();i++){
            if (map.containsKey(s.charAt(i)))
            map.put(s.charAt(i),map.get(s.charAt(i))+1);
            else
                map.put(s.charAt(i),1);

            if (map.containsKey(t.charAt(i)))
                map.put(t.charAt(i),map.get(t.charAt(i))-1);
            else
                map.put(t.charAt(i),-1);
        }
        List<Character> collect = map.entrySet().stream().filter(e -> e.getValue() != 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        if (collect.size()!=0) flag=false;
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("mary","ramy"));
    }
}