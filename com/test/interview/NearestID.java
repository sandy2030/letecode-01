package com.test.interview;

import java.util.*;
public class NearestID {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of IDs
        int n = scanner.nextInt();
        int[] ids = new int[n];
        
        // Read the IDs
        for (int i = 0; i < n; i++) {
            ids[i] = scanner.nextInt();
        }
        
        // Read the target value
        int target = scanner.nextInt();
        
        // Initialize variables to track the nearest ID and the smallest difference
        int nearestId = ids[0];
        int smallestDifference = Math.abs(ids[0] - target);
        
        // Iterate through the IDs to find the nearest one
        for (int i = 1; i < n; i++) {
            int currentDifference = Math.abs(ids[i] - target);
            if (currentDifference < smallestDifference) {
                smallestDifference = currentDifference;
                nearestId = ids[i];
            }
        }
        
        // Output the nearest ID
        System.out.println(nearestId);
        
        scanner.close();
    }
}