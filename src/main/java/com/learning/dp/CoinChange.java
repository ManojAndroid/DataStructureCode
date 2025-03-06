package com.learning.dp;

import java.util.Arrays;

public class CoinChange {
 /* Time Complexity: O(N*sum)
  Auxiliary Space: O(sum)*/
    public static int coinChange(int[] coins, int amount) {
      int[] dp = new int[amount + 1];
      Arrays.fill(dp, amount + 1);
      dp[0] = 0;
      for (int c : coins) {
          for (int j = c; j <= amount; j++) {
              dp[j] = Math.min(dp[j], dp[j - c] + 1);// remember
          }
      }
      return dp[amount] <= amount ? dp[amount] : -1;//remember
  }
  public static void main(String args[])
  {
   /* int coins[] = { 1, 2, 3 };
    int n = coins.length;
    int sum = 4;
    System.out.println(count(coins, n, sum));*/
      int [] arr ={1,2,5};
      int ans=coinChange(arr,11);
      System.out.println(ans);

  }
}
