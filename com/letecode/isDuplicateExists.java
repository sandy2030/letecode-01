package com.letecode;

import java.util.HashSet;
import java.util.Set;

public class isDuplicateExists {
    static Set<Integer> set;
    private static boolean isDuplicateExists(int[]arr){
        set=new HashSet<>();
        for (int i=0;i< arr.length;i++){
            if (set.contains(arr[i]))
                return true;
            set.add(arr[i]);
        }// 1 2 3 4 2
        return false;
    }

    public static void main(String[] args) {
        int []arr={1,2,3,4,5,10};
        boolean duplicateExists = isDuplicateExists(arr);
        System.out.println("duplicate "+duplicateExists);
    }
}
