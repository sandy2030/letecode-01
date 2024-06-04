package com.letecode;

public class MinInRotatedSortedArray {

    private static int minInRotatedSortedArray(int [] arr){
        int left=0;
        int right =arr.length-1;
        int ans=arr[0];
        if (arr.length==1)
            return arr[0];

        while (left<=right){
            if (arr[left]<arr[right]) {
                ans = Math.min(ans, arr[left]);
            }
            int mid=(left+right)/2;
            ans=Math.min(ans,arr[mid]);
            if (arr[left]<=arr[mid])
                left=mid+1;
            else
                right =mid-1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[]={4,5,1,2,3};
        int arr1[]={70,5,-8,77,-785,-88,98};
        System.out.println(minInRotatedSortedArray(arr1));
    }
}
