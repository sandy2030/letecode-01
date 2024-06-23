package com.letecode;

import java.util.*;

public class MinimumLoss_hackerRank {
    public static void main(String[] args) {
        List<Long> price=new ArrayList<>();
        price.add(20l);price.add(7l);price.add(8l);price.add(2l);price.add(5l);

        Map<Long,Integer> map=new HashMap<>();
        for(int i=0;i<price.size();i++){
            map.put(price.get(i),i);
        }
        Collections.sort(price); // 2 5 7 8 20
        long loss=0,minLoss=Long.MAX_VALUE;
        for(int i=price.size()-1;i>0;i--){
            if(map.get(price.get(i))>map.get(price.get(i-1))){ // invalid
                continue;
            }
            loss=price.get(i)-price.get(i-1);
            minLoss=Math.min(loss, minLoss);
        }
        System.out.println(minLoss);
    }

}
