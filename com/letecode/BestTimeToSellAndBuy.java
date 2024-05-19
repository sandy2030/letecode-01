package com.letecode;

public class BestTimeToSellAndBuy {
    private static int bestTimeToSellNBuy(int [] prices){
        int min=prices[0];
        int profit=0;
        for (int i=0;i<prices.length;i++){
            if (prices[i]<min){
                min=prices[i];
            }
            profit=Math.max(profit,prices[i]-min);
        }
        return profit;
    }

    public static void main(String[] args) {
        int arr[]={100,2,5};
        System.out.println(bestTimeToSellNBuy(arr));
    }
}
