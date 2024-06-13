package com.letecode;

import java.util.HashMap;
import java.util.Map;

public class TargetSum_optimized {
    static Map<Integer,Integer> map=null; // for putting number and its index in array
    private static int[] targetSum(int[]arr,int target){
        map=new HashMap<>(); // 1 2 3 4     5
        for (int i=0;i<arr.length;i++){
            int diff=target-arr[i];
            if (!map.containsKey(diff))
                map.put(arr[i],i);  //  get index of existing key, current index
            else {
                System.out.println(map.get(diff)+","+i);
                //return null;
                //return new int[]{map.get(diff),i};
            }
         }
    return null;
}
    public static void main(String[] args) {
        int arr[]={1,2,3,4}; //4 5 2 3 -1 1
        int target=5;
        targetSum(arr,target);
    }
}
