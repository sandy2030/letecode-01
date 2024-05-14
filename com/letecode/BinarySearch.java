package com.letecode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BinarySearch {

    private static int binarySearch(int[]arr,int target){
        int left=0; int right= arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if (target==arr[mid])
                return mid;
            if (arr[left]<=arr[mid]){ // means left array is sorted
                if (target<arr[left] || target>arr[mid]){ //  target is exists in right array
                    left=mid+1;
                }else { // target is in left array
                    right=mid-1;
                }
            }else{  // means  right array is sorted
                if (target<arr[mid] || target>arr[right]){ // means target is in left array
                     right=mid-1;
                }else { //   target is in right array
                    left=mid+1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int a[]={4,5,6,7,0,1,2};

        System.out.println(binarySearch(a,2));
    }
}
