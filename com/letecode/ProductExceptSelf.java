package com.letecode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ProductExceptSelf {
    /*
    *   input array is {1,2,3,4}
    * output array is {24,12,12,6}
    * */
    private static int[] productExceptSelf(int [] arr){
        int pre=1,post=1;
        int[] resultArray=new int[arr.length];
        Arrays.fill(resultArray,1); // initialize result array elements with 1
        for (int i=0;i<arr.length;i++){
            resultArray[i]=pre;
            pre=pre*arr[i];
        }
        for (int i=arr.length-1;i>=0;i--){
            resultArray[i]=resultArray[i]*post;
            post=post*arr[i];
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        IntStream.of(productExceptSelf(arr)).forEach(n-> System.out.print(n+","));
    }
}
