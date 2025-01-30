package com.learn.stream;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[]={1,3,6,8,12,34,56,78};
        int target=34;
        System.out.println(bst(arr,0,arr.length-1,target));
    }
    static int bst(int arr[],int start,int last,int target){
        int mid=start+(last-start)/2;
        if (arr[mid]==target){
            return mid;
        }else {
            if (arr[mid]>target){
               return bst(arr,start,mid,target);
            }else if (arr[mid]<target){
                return bst(arr,mid,last,target);
            }
        }
            return -1;
    }
}
