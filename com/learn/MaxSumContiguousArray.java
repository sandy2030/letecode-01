package com.learn;
public class MaxSumContiguousArray {
    public static void main(String[] args) {
        int a[]={-2,-3, 4, -1, -2, 1, 5, -3};
        int a1[]={-2,3,0,1,-4,5};
        System.out.println(maxSum(a1));
    }
    private static int maxSum(int a[]){
        int max=0;
        int max_so_far=0;
           for(int i=0;i<a.length;i++){
            max=max+a[i] ;
            if(max<0) max=0;
            if(max_so_far<max){
                max_so_far=max;
            }
        }
        return max_so_far;
    }
}