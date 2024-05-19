package com.letecode;

public class SearchInRotatedSortedArray {

    private static int searchInRotatedSortedArray(int arr[],int target){

        int left=0,right=arr.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if (target==arr[mid])
                return mid;
            if (arr[left]<=arr[mid]){  // 1st half of array is sorted
                if (target<arr[left] || target>arr[mid]){
                    left=mid+1;
                }else {
                    right=mid-1;
                }
            }else {  // 2nd half array is sorted
                if (target<arr[mid]||target>arr[right]){
                    right=mid-1;
                }else
                    left=mid+1;
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        int arr[]={7,0,1,2,3,4,5,6};
        System.out.println(searchInRotatedSortedArray(arr,60));
    }
}
