package com.letecode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaaxProfitFromStockTrad {

    public static void main(String[] args) {
        int budget=10;
        int  present[]={5,4,6,2,3};
        int  future[]={8,5,4,3,5};
        // 3 1 -2 1 2
        // 3 2 1 1 -2
        // 5 3 4 2 6
        //System.out.println(maximumProfitFromStockTrade(present,future,budget));
        System.out.println(maxProfit(present,future,budget));
    }

    private static int maxProfit(int[] present, int[] future, int budget) {
        Map<Integer,Integer> map=new HashMap<>();
for(int i=0;i<present.length;i++){
    int diff=future[i]-present[i];
    map.put(present[i],diff);
}
        Map<Integer, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((a,b)->b-a))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    //10
    //[5 ,3] , [3 ,2] , [2 ,1] , [4 ,1] , [6 ,-2] ,
    int val=0;
    for (Map.Entry<Integer,Integer> entry:sortedMap.entrySet()){
        if(budget-entry.getKey()>=0){
            budget=budget-entry.getKey();
            val+=entry.getValue();
        }
    }
        return val;
    }
}