package com.letecode;

public class SubarrayFinder {
    public static void main(String[] args) {
        int[] arr = {1, 2, -1};
        findSubarrays(arr);
    }

    public static void findSubarrays(int[] arr) {
        int n = arr.length;
        // Loop through the starting index
        for (int start = 0; start < n; start++) {
            // Loop through the ending index
            for (int end = start; end < n; end++) {
                // Print the subarray from start to end
                System.out.print("{ ");
                for (int i = start; i <= end; i++) {
                    System.out.println("start "+start);
                    System.out.print(arr[i] + " ,");
                }
                System.out.print("}");
                System.out.println();
            }
        }
    }
}
