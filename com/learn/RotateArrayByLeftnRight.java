package com.learn;

import java.util.Arrays;

public class RotateArrayByLeftnRight {

    static void rotateRight(int arr[],int k){
        int n=k%arr.length;
        reverse(arr,0,arr.length-1);
        reverse(arr,0,k-1);
        reverse(arr,k,arr.length-1);
    }
    static void rotateLeft(int arr[],int k){
            int n=k%arr.length;
            reverse(arr,0,k-1);
            reverse(arr,k,arr.length-1);
            reverse(arr,0,arr.length-1);
    }
    static void reverse(int arr[],int start,int end){
        while (start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
              start++;
              end--;
        }
    }
    public static void main(String[] args) {
            int arr[]={1,2,3,4,5,6};
            int k=4;
            //rotateLeft(arr,k);
        //Arrays.stream(arr).forEach(x-> System.out.print(x+" ,"));
        rotateRight(arr,k);
        System.out.println();
        Arrays.stream(arr).forEach(x-> System.out.print(x+" ,"));
    }
}
