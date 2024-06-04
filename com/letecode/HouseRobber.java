package com.letecode;

public class HouseRobber {
    private static int rob(int[] nums){
        int n=nums.length;
        int a[]=new int[n];
        a[0]=nums[0];
        a[1]=Math.max(nums[0],nums[1]);
        for (int i=2;i<nums.length;i++){
            a[i]=Math.max(nums[i]+a[i-2],a[i-1]);
        }
        return a[n-1];
    }
    public static void main(String[] args) {
        int[]nums={4,7,2,11,0,1};
        System.out.println(rob(nums));
    }
}
