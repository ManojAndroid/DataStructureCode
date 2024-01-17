package com.learning;

public class CountPossibleDecodings {
//https://www.youtube.com/watch?v=o1i7JYWbwOE&ab_channel=KnowledgeCenter
  //youtube vide
  public static int decodeWays(String s) {
    if (s.length() == 0 || s.charAt(0) == '0') {
      return 0;
    }
    if (s.length() == 1) {
      return 1;
    }
    int count1 = 1, count2 = 1;
    for (int i = 1; i < s.length(); i++) {
      int d = s.charAt(i) - '0';
      int dd = (s.charAt(i - 1) - '0') * 10 + d;
      int count = 0;
      if (d > 0) {
        count += count2;
      }
      if (dd >= 10 && dd <= 26) {
        count += count1;
      }
      count1 = count2;//prev to perv
      count2 = count;//prev value

    }
    return count2;

  }
//using DP
  public int CountWays(String str)
  {
    int n = str.length();
    if (n == 0) {
      return 0;
    }

    // Initialize the DP array
    int[] dp = new int[n + 1];
    dp[n] = 1; // There is one way to decode an empty string

    // Fill in the DP array from right to left
    for (int i = n - 1; i >= 0; i--) {
      // Check for leading zero
      if (str.charAt(i) == '0') {
        dp[i] = 0;
      } else {
        // Decode single digit
        dp[i]= dp[i]+dp[i + 1];

        // Decode two digits if possible
        if (i + 1 < n && Integer.parseInt(str.substring(i, i + 2)) <= 26) {
          dp[i]=dp[i]+ dp[i + 2];
        }
      }
    }

    return dp[0];
  }

  public static void main(String[] args) {
    String str = "226";
    System.out.println(CountPossibleDecodings.decodeWays(str));

  }

}


/*Example 1:

    Input: s = "12"
    Output: 2
    Explanation: "12" could be decoded as "A B" (1 2) or "L" (12).A. B
    Example 2:

    Input: s = "226"
    Output: 3
    Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
    Example 3:

    Input: s = "06"
    Output: 0
    Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").*/
