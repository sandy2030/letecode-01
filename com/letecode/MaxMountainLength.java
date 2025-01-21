package com.letecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class MaxMountainLength {
    public static void main(String[] args) {
        //int arr[]={1 ,3, 2, 4, 5, 6, 7, 3, 1, 0, 5, 7, 3};
        //int arr[]=null;
        //int arr[]={1,4,2};
        //int arr[]={2,1,4,7,3,2,5};
        //int arr[]={0,1,2,3,4,5,4,3,2,1,0};
        //int arr[]={0,1,2,3,4,5,6,7,8,9};
            //int arr[]={7,4,8};
            //int arr[]={2,1,4,7,3,2,5};
            //int arr[]={0,1,2,3,4,5,4,3,2,1,0};
            int arr[]={0,2,0,2,1,2,3,4,4,1};

        System.out.println(new MaxMountainLength().longestMountain(arr));
    }
        public int longestMountain(int[] arr) {
            int n = arr.length;
            if (n < 3) return 0;

            int longest = 0;

            for (int i = 1; i < n - 1; i++) {
                // Check if arr[i] is a peak
                if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                    int left = i - 1;
                    int right = i + 1;

                    // Move left pointer to the start of the mountain
                    while (left > 0 && arr[left - 1] < arr[left]) {
                        left--;
                    }

                    // Move right pointer to the end of the mountain
                    while (right < n - 1 && arr[right] > arr[right + 1]) {
                        right++;
                    }

                    // Calculate the length of the current mountain
                    int currentMountainLength = right - left + 1;

                    // Update the longest mountain found
                    longest = Math.max(longest, currentMountainLength);

                    // Move the index to the end of the current mountain
                    //i = right;
                }
            }
            return longest;
        }
}