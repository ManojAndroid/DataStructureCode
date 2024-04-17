package com.learning;

public class LongestCommonSubsequence {
    // Longest Common Subsequence (LCS) using Bottom-Up (Tabulation):
/*
    We can use the following steps to implement the dynamic programming approach for LCS.
    Create a 2D array dp[][] with rows and columns equal to the length of each input string plus 1 [the number of rows indicates the indices of S1 and the columns indicate the indices of S2].
    Initialize the first row and column of the dp array to 0.
    Iterate through the rows of the dp array, starting from 1 (say using iterator i).
    For each i, iterate all the columns from j = 1 to n:
    If S1[i-1] is equal to S2[j-1], set the current element of the dp array to the value of the element to (dp[i-1][j-1] + 1).
    Else, set the current element of the dp array to the maximum value of dp[i-1][j] and dp[i][j-1].
    After the nested loops, the last element of the dp array will contain the length of the LCS.*/
    //https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/ link

   // Time Complexity: O(m * n) which is much better than the worst-case time complexity of Naive Recursive implementation.
   // Auxiliary Space: O(m * n) because the algorithm uses an array of size (m+1)*(n+1) to store the length of the common substrings.
    static int lcs(String X, String Y, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        // Following steps build L[m+1][n+1] in bottom up
        for (int i = 0; i <=m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;// pick previous digonal value +1
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);//pick max prev row or colum valure
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String S1 = "AGGTAB";
        String S2 = "GXTXAYB";
        int m = S1.length();
        int n = S2.length();

        System.out.println("Length of LCS is"
                + " " + lcs(S1, S2, m, n));
    }
}
