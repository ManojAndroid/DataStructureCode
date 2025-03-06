package clientQuestion;

public class EditDistanceVVI {
    //https://leetcode.com/problems/edit-distance/
  /*  Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
    You have the following three operations permitted on a word:
    Insert a character
    Delete a character
    Replace a character*/
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // dp[0][0] = 0; // for base case id string are empty
        for (int i = 1; i <= m; i++) {// base case if 3 chars then 3 operaton will required
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {// base case if 3 chars then 3 operaton will required
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];// no operation need take digonal value
                else
                    // pick min from all three diog,down,up+1,
                    dp[i][j] = Math.min(dp[i - 1][j-1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
       /* Example 1:

        Input: word1 = "horse", word2 = "ros"
        Output: 3
        Explanation:
        horse -> rorse (replace 'h' with 'r')
        rorse -> rose (remove 'r')
        rose -> ros (remove 'e')*/
    }
}
