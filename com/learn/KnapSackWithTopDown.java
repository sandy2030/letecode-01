package com.learn;

public class KnapSackWithTopDown {
    private static int t[][] = new int[6][6];

    // knapsack(wt,val,w-wt[n-1],n-1)
    private static int knapSackWithTopDown(int weight[], int val[], int w, int n) {
        // 2D array initialization
        for (int i = 0; i < n + 1; i++){
            for (int j = 0; j < w + 1; j++){
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
    }
}

        // main code
        for (int i=1 ;i < n+1; i++){
            for (int j = 1; j < w+1; j++) {
                if (weight[i - 1] <= j)
                    t[i][j] = Math.max(val[i-1]+t[i - 1][j - weight[i - 1]], t[i - 1][j]);
                else
                    t[i][j] = t[i - 1][j];
            }
    }
            return t[n][w];
    }
    public static void main(String[] args) {
        int n=5,w=5;
        int[] profit={1,2,3,4,11};
        int weight[] = {1, 3, 5,2,4};
        System.out.println("answer:   "+knapSackWithTopDown(weight,profit,w,n));
    }
}