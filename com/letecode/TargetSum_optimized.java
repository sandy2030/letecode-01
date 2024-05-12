package com.letecode;

import java.util.HashMap;
import java.util.Map;

public class TargetSum_optimized {
    static Map<Integer,Integer> map=null;
    private static int[] targetSum(int[]arr,int target){
        map=new HashMap<>();
        for (int i=0;i<arr.length;i++){
            int diff=target-arr[i];
            if (map.containsKey(diff)){
                int[]result=new int[]{map.get(diff),i};
                System.out.println("("+map.get(diff)+","+i+")");
            }
            map.put(arr[i],i);
        }
    return null;
}
    public static void main(String[] args) {
        int arr[]={2,1,4,3,7,5};
        int target=6;
        targetSum(arr,target);
    }
}
