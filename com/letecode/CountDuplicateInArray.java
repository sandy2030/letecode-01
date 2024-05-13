package com.letecode;

import java.util.HashMap;
import java.util.Map;

public class CountDuplicateInArray {
    static Map<Integer,Integer> map;
    private static boolean isDuplicateExists(int[] arr){
        map=new HashMap<>();
        int count=1;
        boolean isDuplicateExists =false;
        for (int i=0;i<arr.length;i++){
            if (map.containsKey(arr[i])) {
                isDuplicateExists = true;
                count++;
            }
            map.put(arr[i], count);
        }
        map.forEach((k,v)-> System.out.print("("+k+","+v+") ,"))  ;
        System.out.println();
        return isDuplicateExists;
    }
    public static void main(String[] args) {
        int arr[]={1,2,22,3,4,5,22};
        System.out.println("is duplicate exists: "+isDuplicateExists(arr));
    }
}
