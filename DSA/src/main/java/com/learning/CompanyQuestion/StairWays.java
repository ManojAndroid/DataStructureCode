package com.learning.CompanyQuestion;

public class StairWays {
    /* Time Complexity: O(n).
     Space Complexity: O(n).*/
    static int countStairUsingstep12(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /*   Time Complexity : O(n)
       Space Complexity : O(1)*/
    static int printCountDP(int dist) {
        // Create the array of size 3.
        int[] ways = new int[3];
        int n = dist;
        // Initialize the bases cases
        ways[0] = 1;
        ways[1] = 1;
        ways[2] = 2;
        // Run a loop from 3 to n
        // Bottom up approach to fill the array
        for (int i = 3; i <= n; i++)
            ways[i % 3] = ways[(i - 1) % 3] + ways[(i - 2) % 3] + ways[(i - 3) % 3];

        return ways[n % 3];
    }
   //recursion
    //exponential time complexity (O(2^n)) due to redundant calculations.
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public static void main(String[] args) {
        countStairUsingstep12(4);
    }
}
