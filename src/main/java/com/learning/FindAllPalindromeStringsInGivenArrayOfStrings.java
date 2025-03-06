package com.learning;

import java.util.ArrayList;
import java.util.List;

public class FindAllPalindromeStringsInGivenArrayOfStrings {
   /* Time complexity: O(N * W) where W is the average length of the strings
    Auxiliary Space: O(N * W)*/
    public static List<String> allPalindrome(String[] strList) {
        List<String> palindromeList = new ArrayList<>();
        for (String str : strList) {
            if (isPalindrome(str)) {
                palindromeList.add(str);
            }
        }
        return palindromeList;
    }

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (right > left) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String []arr
                = { "abc", "car", "ada", "racecar", "cool" };
        // Print required answer
        List<String> s = allPalindrome(arr);
        s.forEach(System.out::println);
    }
}
