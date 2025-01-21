package com.letecode;

public class MaxProductSubArray {

    private static int maxProductSybArray(int[]arr){
        if(arr.length==0) return 0;

        int max=arr[0];
        int min=arr[0];
        int result=max;
        for(int i=1;i<arr.length;i++){
            int cur=arr[i];
            int temp=Math.max(cur,Math.max(cur*max,cur*min));
            min=Math.min(cur,Math.min(cur*min,cur*max));
            max=temp;
            result=Math.max(max,result);
        }
        return result;
    }
    public static void main(String[] args) {
        int arr[]={-2, 6, -3, -10, 0, 2};
        System.out.println(maxProductSybArray(arr));
    }
}
