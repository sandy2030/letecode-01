package com.letecode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    static void twoSum(int[]arr,int target){
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<arr.length;i++){
            int diff=target-arr[i];
            if (!map.containsKey(diff))
                map.put(arr[i],i);
            else {
                System.out.println(map.get(diff)+","+i);
            }
        }
    }

    private static void twoSum1(int arr[],int target){
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<arr.length;i++){
            int diff=target-arr[i];
               if (map.containsKey(diff)){
                   System.out.println(map.get(diff)+" , "+i);
               }else {
                   map.put(arr[i],i);
               }
        }
    }
    public static void main(String[] args) {
        //int arr[]={11,5,8,9,6,15};
        int arr[]={9,5,6,8,11,12};
        twoSum1(arr,20);
    }
}
