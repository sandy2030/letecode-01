package com.letecode;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ThridMax {
    public static int thirdMax(int[] nums) {
        Set set = new HashSet<Integer>();
        for (Integer i : nums) {
            set.add(i);
            if (set.size() > 3) {
                set.remove(Collections.min(set));
            }
        }
        int result;
        if (set.size() < 3)
            result=Integer.valueOf(Collections.max(set).toString()); // if array length is less than 3 than return max
        else
            result=Integer.valueOf(Collections.min(set).toString());
        return result;
    }

    public static void main(String[] args) {
        // return 3rd max , if array lenght is less than 3 than return max
        int [] arr={2,5,6,21,78,87,312}; // 2,5,6,21,78,87,312
        System.out.println(thirdMax(arr));
    }
}

