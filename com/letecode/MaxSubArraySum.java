package com.letecode;

public class MaxSubArraySum {
    private static int maxSubArray(int arr[]){
        int curSum=0;
        int maxSum=arr[0];
        for(int i=0;i<arr.length;i++){
            if (curSum<0)
                curSum=0;
            curSum=curSum+arr[i];
            maxSum=Math.max(curSum,maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[]={5,4,-1,7,-8};
        int a1[]={-2,3,0,1,-4,5};
        System.out.println(maxSubArray(a1));
    }
}
