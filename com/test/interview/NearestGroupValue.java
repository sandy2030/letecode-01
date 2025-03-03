package com.test.interview;

import java.util.*;

public class NearestGroupValue {
    
    // Function to find the nearest ID to the group value
    public static int findNearestID(Map<Integer, Integer> idMap, int groupValue) {
        int nearestID = -1;    // Initialize with -1 or any invalid ID
        int minDiff = Integer.MAX_VALUE;  // Large initial value for min difference
        
        // Iterate over the ID map
        for (Map.Entry<Integer, Integer> entry : idMap.entrySet()) {
            int id = entry.getKey();
            int value = entry.getValue();
            
            // Calculate the absolute difference from the group value
            int diff = Math.abs(value - groupValue);
            
            // Check if this ID is closer to the group value
            if (diff < minDiff || (diff == minDiff && id < nearestID)) {
                nearestID = id;
                minDiff = diff;
            }
        }
        
        return nearestID;  // Return the ID that has the nearest value
    }
    
    public static void main(String[] args) {
        // Example input
        Map<Integer, Integer> idMap = new HashMap<>();
        idMap.put(1001, 50);
        idMap.put(1002, 60);
        idMap.put(1003, 55);
        idMap.put(1004, 62);
        
        int groupValue = 58;
        
        // Find and print the ID with the nearest value to the group value
        int nearestID = findNearestID(idMap, groupValue);
        System.out.println("The ID nearest to the group value is: " + nearestID);
    }
}
