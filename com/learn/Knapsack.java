package com.learn;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Knapsack {
    // N = 3, W = 4, profit[] = {1, 2, 3}, weight[] = {4, 5, 1}

    // always create matrix of t[n+1][w+1] size
    static int t[][]=new int[6][5];
private static int knapsack(int weight[],int profit[],int w,int n){
    if(n==0 || w==0)
        return 0;

    if (t[n][w] != -1)
        return t[n][w];

    if (weight[n-1]<=w){
      t[n][w]=Math.max(profit[n-1]+knapsack(weight,profit,w-weight[n-1],n-1),knapsack(weight,profit,w,n-1));
    } else {
        t[n][w] = knapsack(weight, profit, w, n - 1);
    }

     return t[n][w];
}
private static void memset(){
for(int[]a:t){
    Arrays.fill(a,-1);;
        }
    }
    public static void main(String[] args) {
        int n=5,w=4;
        memset();
        int[] profit={1,2,3,4,11};
        int weight[] = {1, 3, 5,2,4};
        System.out.println("answer:   "+knapsack(weight,profit,w,n));

        for (int j=0;j<n;j++){
            System.out.println(Arrays.toString(t[j]));
        }
    }
}