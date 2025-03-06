package com.learning;

import java.util.Map;

public class DiceThrow {
    //https://www.youtube.com/watch?v=nQw9gVaIjGo
    static final int MOD = 1000000007;
    public static int numRollsToTarget(int n, int k, int target) {
        return solve(n, k, target);
    }

    static int solve(int n, int k, int target) {
        if (target < 0)
            return 0;
        if (n == 0 && target == 0) {
            return 1;
        }
        int ways = 0;
        for (int face = 1; face <= k; face++) {
            ways = ways + solve(n - 1, k, target - face);// % 1000000007;
        }
        return ways;
    }

    public static int solveUsingDp(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <n+1; i++) {
            for (int j = 1; j <target+1; j++) {
                for (int face = 1; face <= k; k++) {
                   if(j>=face) {
                       dp[i][j] =  dp[i][j] + dp[i - 1][j - face]%MOD ;
                   }
                }
            }
        }
        return dp[n][target];
    }
    public static void main(String[] args) {
        int n = 2;
        int k = 6;
        int target = 7;
        //System.out.println(numRollsToTarget(n, k, target));
        System.out.println("using dp");
        System.out.println("dp result: "+solveUsingDp(n,k,target));
    }
}
