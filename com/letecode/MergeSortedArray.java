package com.letecode;

import java.util.Arrays;
public class MergeSortedArray {
    private static int[] mergeSortedArray(int[]a,int[]b){
        int r[]=new int[a.length+b.length];
        int len1=a.length;
        int len2=b.length;
        int i=0,j=0,k=0;
        while (i<len1 && j<len2){
            if (a[i]<b[j])
                r[k++]=a[i++];
            else
                r[k++]=b[j++];
        }
        while (i<len1)
                r[k++]=a[i++];
            while (j<len2)
                r[k++]=b[j++];
        return r;
    }
    public static void main(String[] args) {
        int[]a={1,1,5};
        int[]b={2,4,5,7};
        int r[]=mergeSortedArray(a,b);
        Arrays.stream(r).forEach(s-> System.out.print(s+","));
    }
}