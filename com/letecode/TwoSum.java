package com.letecode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
//11,5,8,9,6
    static int[] twoSum(int[]arr,int target){
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<arr.length;i++){
            int diff=target-arr[i];
            if (!map.containsKey(diff))
                map.put(arr[i],i);
            else {
                System.out.println(map.get(diff)+","+i);
                    return new int[]{map.get(diff),i};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int arr[]={11,5,8,9,6};
        System.out.println(twoSum(arr,20));
    }
}
