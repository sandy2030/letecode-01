package com.letecode;

import java.util.ArrayList;
import java.util.List;

public class HackerRankTest {
    public static long maxSubarrayValue(List<Integer> arr) {
        int eSum=0;
        int oSum=0;
        Integer array[]=arr.toArray(new Integer[0]);
        for (int i = 0; i < arr.size(); i++) {
            if(i%2==0){
                eSum=eSum+array[i];
            }else{
                oSum+=array[i];
            }
        }
        System.out.println("esum "+eSum+" osum "+oSum);
        return 3l;
    }

    public static void main(String[] args) {
        int a[]={1,2,-1,5,-8}; // {1} {2} {-1} {5} {-8}  {1,2} {2,-1} {-1,5} {5,-8} {1,2,-1} {2,-1,5} {-1,5,-8} {1,2,-1,5} {2,-1,5,-8} {1,2,-1,5,-8}
        List list=new ArrayList();
        list.add(1);list.add(2);list.add(-1);list.add(5);list.add(-8);
        System.out.println(maxSubarrayValue(list));
    }
}
