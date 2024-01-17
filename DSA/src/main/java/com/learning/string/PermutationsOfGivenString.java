package com.learning.string;

public class PermutationsOfGivenString {

  static void permute(String str, String answer) {

    if (str.length() == 0) {
      System.out.println(answer);
      return;
    }
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      String leftStr = str.substring(0, i);
      String right = str.substring(i + 1);
      String res = leftStr + right;
      permute(res, answer + ch);
    }
  }

  public static void main(String[] args) {
    String s = "ABC";
    String answer = "";
    System.out.print("\nAll possible strings are : ");
    permute(s, answer);
  }
}
