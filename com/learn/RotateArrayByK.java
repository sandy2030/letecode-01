package com.learn;

public class RotateArrayByK {

    static void rotate(int arr[],int k){
        reverse(arr,0,arr.length-1);
        reverse(arr,0,k-1);
        reverse(arr,k,arr.length-1);

        for (int i:arr)
            System.out.print(i+" ,");
    }
    static void  reverse(int arr[],int start, int end){
        while (start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
            int arr[]={1,2,3,4,5,6,7};
            int k=4;
            rotate(arr,k);
    }

}
