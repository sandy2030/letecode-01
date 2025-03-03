package com.test.interview;

import java.util.Scanner;

public class FlowerStemSize {
    /*
    * You are given an array of integers representing the sizes of flower stems. Your task is to find the maximum difference
    * between the sizes of any two stems in the array.
    * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] stems = new int[n];
        
        for (int i = 0; i < n; i++) {
            stems[i] = scanner.nextInt();
        }
        
        int minSize = Integer.MAX_VALUE;
        int maxSize = Integer.MIN_VALUE;
        
        for (int size : stems) {
            if (size < minSize) {
                minSize = size;
            }
            if (size > maxSize) {
                maxSize = size;
            }
        }
        
        int maxDifference = maxSize - minSize;
        System.out.println(maxDifference);
        
        scanner.close();
    }
}
