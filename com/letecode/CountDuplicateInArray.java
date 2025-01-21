package com.letecode;

import java.util.HashMap;
import java.util.Map;

public class CountDuplicateInArray {
    static Map<Integer,Integer> map;
    private static boolean isDuplicateExists(int[] arr){
        map=new HashMap<>();
        int count=0;
        boolean isDuplicateExists =false;
        for (int i=0;i<arr.length;i++){
            if (map.containsKey(arr[i])) {
                count=map.get(arr[i]);
                map.put(arr[i],count+1);
                isDuplicateExists = true;
            }
            else
            map.put(arr[i], 1);
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
                if (entry.getValue()>1)
                    System.out.println(entry.getKey());
        }
        System.out.println();
        return isDuplicateExists;
    }
    public static void main(String[] args) {
        int arr[]={1,2,22,3,4,5,22,1};
        System.out.println("is duplicate exists: "+isDuplicateExists(arr));
    }
}
