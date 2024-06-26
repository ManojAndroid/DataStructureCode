package com.learning.dp;

import java.util.HashSet;
import java.util.Set;

public class SubsetSumProblem {

  /* Complexity Analysis:
   Time Complexity: O(sum*n), where sum is the ‘target sum’ and ‘n’ is the size of array.
   Auxiliary Space: O(sum*n), as the size of 2-D array is sum*n. + O(n) for recursive stack space*/

  static boolean isSubsetSum(int set[], int n, int sum)
  {
    // The value of subset[i][j] will be
    // true if there is a subset of
    // set[0..j-1] with sum equal to i
    boolean subset[][] = new boolean[sum + 1][n + 1];

    // If sum is 0, then answer is true
    for (int i = 0; i <= n; i++)
      subset[0][i] = true;

    // If sum is not 0 and set is empty,
    // then answer is false
    for (int i = 1; i <= sum; i++)
      subset[i][0] = false;

    // Fill the subset table in bottom
    // up manner
    for (int i = 1; i <= sum; i++) {
      for (int j = 1; j <= n; j++) {
        subset[i][j] = subset[i][j - 1];//insert previous value
        if (i >= set[j - 1])
          subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
      }
    }

        /* // uncomment this code to print table
        for (int i = 0; i <= sum; i++)
        {
        for (int j = 0; j <= n; j++)
            System.out.println (subset[i][j]);
        } */

    return subset[sum][n];
  }

  /* Driver code*/
  public static void main(String args[])
  {
    int set[] = { 3, 34, 4, 12, 5, 2 };
    int sum = 9;
    int n = set.length;
    if (isSubsetSum(set, n, sum) == true)
      System.out.println("Found a subset"
          + " with given sum");
    else
      System.out.println("No subset with"
          + " given sum");
  }
}
