package com.practice;

public class BestTimeToSellnBuyPractice {

    static int m(int[]a){
        if (a.length==0) return 0;
        int  min=a[0];
        int profit=0;
        for(int i=1;i<a.length;i++){
            if (a[i]<min){
                min=a[i];
            }
            profit=Math.max(profit,a[i]-min);
        }
        return profit;
    }
    public static void main(String[] args) {
        int []a={1,5,2,8};
        System.out.println(m(a));
    }
}
