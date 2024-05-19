package com.letecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    static Map<Integer,Integer> map;
    public static int findTargetSum(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array first
        Arrays.stream(nums).forEach(a-> System.out.print(a+","));
        System.out.println();
        int left = 0;
        int right = nums.length - 1;
        int pairs=0;
        while (left < right) {
            int currentSum = nums[left] + nums[right];
            if (currentSum == target) {
                pairs++;
                System.out.println("("+left+","+right+")");
                left++;
                right--;
            } else if (currentSum < target) {
                left++; // Move left pointer to increase the sum
            } else {
                right--; // Move right pointer to decrease the sum
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        int []arr={9,9,5,6,8,11,12}; //
        int target=20;
        int pairs=findTargetSum(arr,target);
        System.out.println("pairs count :"+pairs);
    }
}