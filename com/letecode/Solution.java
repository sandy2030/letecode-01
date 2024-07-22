package com.letecode;

class Solution {
    public static int maximumProfit(int[] presentValues, int[] futureValues, int budget) {
        int numberOfItems = presentValues.length; // Total number of items
  
        // dp array to store the maximum profit for each budget upto the given budget
        int[] dp = new int[budget + 1];
  
        // Iterate over each item
        for (int i = 0; i < numberOfItems; i++) {
            int presentValue = presentValues[i];
            int futureValue = futureValues[i];
          
            // Iterate over all possible remaining budgets in reverse
            // to avoid using same item's profit more than once
            for (int currentBudget = budget; currentBudget >= presentValue; currentBudget++) {
                // Update dp array with the maximum profit achievable with the current budget
                dp[currentBudget] = Math.max(dp[currentBudget], dp[currentBudget - presentValue] + futureValue - presentValue);
            }
        }
      
        // Return the maximum profit that can be achieved with the given budget
        return dp[budget];
    }

    public static void main(String[] args) {
        int  present[]={1,2,3};
        int  future[]={2,3,5};
        int budget=5;
        System.out.println(maximumProfit(present,future,budget));
    }
}