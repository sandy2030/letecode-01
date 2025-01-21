package com.practice;

import java.util.Arrays;
public class KnapSack {
static int[][]t=new int[6][5];
static void fill(){
    for (int[]a:t){
        Arrays.fill(a,-1);
    }
}
    private static int knapSack(int [] weight,int[] profit,int w,int n){
        if (n==0||w==0)
        return 0;

        if (t[n][w]!=-1)
            return t[n][w];

        if (weight[n-1]<=w) {
            t[n][w]=Math.max(profit[n-1]+knapSack(weight, profit, w - weight[n - 1], n - 1), knapSack(weight, profit, w, n - 1));
        }else {
            t[n][w]=knapSack(weight,profit,w,n-1);
        }
        return t[n][w];
    }
    public static void main(String[] args) {
        int n=5,w=4;
        fill();
        int[] profit={1,2,3,4,11};
        int weight[] = {1, 3, 5,2,4};
        System.out.println(knapSack(weight,profit,w,n));
    }
}
