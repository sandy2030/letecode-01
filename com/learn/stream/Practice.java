package com.learn.stream;

import java.util.HashMap;
import java.util.Map;

public class Practice {
    public static void main(String[] args) {
  int num[]={2,7,11,15};
  int target=9;
  int temp=0;
  Map<Integer,Integer> map=new HashMap<>();

  for(int i=0;i<num.length;i++){
      if (!map.containsKey(num[i]))
      map.put(num[i],i);
      temp=target-num[i];
      if (map.containsKey(temp)){
          
      }
          
  }

    }
}
