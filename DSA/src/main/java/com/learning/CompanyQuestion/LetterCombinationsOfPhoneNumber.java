package com.learning.CompanyQuestion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
  // O(4^n)
  // https://leetcode.com/problems/letter-combinations-of-a-phone-number/submissions/
  ///https://www.youtube.com/watch?v=21OuwqIC56E&ab_channel=KevinNaughtonJr.

  public  static List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return result;
    }
    String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    backtrack(result, digits, "", 0, mapping);
    return result;
  }

  static void backtrack(List<String> result, String digits, String current, int index,
      String[] mapping) {
    if (index == digits.length()) {
      result.add(current);
      return;
    }
    String letters = mapping[digits.charAt(index) - '0'];

    for (int i = 0; i < letters.length(); i++) {
      backtrack(result, digits, current + letters.charAt(i), index + 1, mapping);
    }

  }

  public static void main(String[] args) {

    List<String> result=LetterCombinationsOfPhoneNumber.letterCombinations("23");

    for(String str:result)
    {
      System.out.print(str+",");
    }
  }

}
