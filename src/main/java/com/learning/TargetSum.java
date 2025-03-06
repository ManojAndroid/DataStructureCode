package com.learning;

public class TargetSum {
    public static int findTargetSumWays(int[] nums, int S) {
        // Calculate the total sum of the array
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // If the total sum is less than the target sum or their difference is odd, no solution exists
        if (sum < S || (sum + S) % 2 != 0) {
            return 0;
        }

        // Calculate the target subset sum
        int targetSubsetSum = (sum + S) / 2;

        // Initialize a DP array to store the number of ways to reach each sum
        int[] dp = new int[targetSubsetSum + 1];
        dp[0] = 1;//base case for zero

        // Iterate through the array and update the DP array
        for (int num : nums) {
            for (int i = targetSubsetSum; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        // Return the number of ways to reach the target sum
        return dp[targetSubsetSum];
    }
}
