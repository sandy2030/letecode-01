package com.test;

public class Problem {

    // [2 5 1 0 7 8]    w=12  n=6
    static int knapSack(int arr[],int w,int n){
        if (n==0 || w==0)
            return 0;
        int sum=0;
        if (arr[n-1]<=w) {
            sum =Math.max(arr[n - 1] + knapSack(arr, w - arr[n - 1], n - 1),knapSack(arr, w - arr[n - 1], n - 1));
        }else
            sum=knapSack(arr, w - arr[n - 1], n - 1);
        System.out.println("sum " + sum);

        return 0;
    }

    public static void main(String[] args) {
        int ar[]={2, 5, 1, 0, 7, 8};   int  w=12,  n=6;
        knapSack(ar,w,n);
    }
}
