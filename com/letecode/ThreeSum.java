package com.letecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    private static List<List<Integer>> threeSum(int arr[]){
        Arrays.sort(arr);
        List<List<Integer>> result=new ArrayList<>();
        for (int i=0;i<arr.length && arr[i]<=0;i++){
            if (i==0 || arr[i]!=arr[i-1]){
                twoSum(arr,i,result);
            }
        }
        return result;
    }

    private static void twoSum(int[] arr, int i, List<List<Integer>> result) {
           int left=i+1, right=arr.length-1;
           while (left<right){
                int sum=arr[i]+arr[left]+arr[right];
                if (sum<0)
                    left++;
                else if (sum>0)
                    right--;
                else {
                    result.add(Arrays.asList(arr[i],arr[left],arr[right]));
                    left++;right--;
                    while (left<right &&  arr[left]==arr[left-1]){
                            ++left;
                    }
                }
           }
    }

    public static void main(String[] args) {
        int arr[]={-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));
    }
}
