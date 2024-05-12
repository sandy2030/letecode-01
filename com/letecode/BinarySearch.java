package com.letecode;

public class BinarySearch {

    private static int binarySearch(int[]arr,int key){
        int low=0;int high=arr.length-1;
        while (low<=high) {
            int mid = (low + high) / 2;

            if (key == arr[mid])
                return mid;
            else if (key < arr[mid])
                high = mid - 1;
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int a[]={1,4,6,7,12,23,45,56,78,90};

        System.out.println(binarySearch(a,9));
    }
}
