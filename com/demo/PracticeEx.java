package com.demo;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;

public class PracticeEx {
    public static void main(String[] args) {
        double [] numbers={12,1,0,3,5,6,2,1,5,3};
        //   12,1,0,3,5,6,2,1,5,3
        // 0 1 1 2 3 3 5 5  6 12
        float f=5.6789f;
        DecimalFormat df=new DecimalFormat("#.00");
        System.out.println(df.format(f));



        System.out.println("mean: "+mean(numbers));
        System.out.println("median: "+median(numbers));
    }
    static double mean(double [] num){
        double sum=0;
        for(double d:num){
            sum+=d;
        }
        return sum/num.length;
    }

    static double median(double [] num){
        Arrays.sort(num);
        if (num.length==0)
            return  0;
        else if (num.length==1)
            return  num[0];
        else{//1 2 3 4 5 6
            if (num.length%2!=0){
                return num[(num.length-1)/2];
            }else {
                return (num[num.length/2]+num[(num.length/2)-1])/2;
            }
        }
    }


}
