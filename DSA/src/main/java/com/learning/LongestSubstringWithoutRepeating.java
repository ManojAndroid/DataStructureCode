package com.learning;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int startIndex = 0;

        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
            char currentChar = s.charAt(endIndex);

            if (charIndexMap.containsKey(currentChar)) {
                // Update the start index to the next character after the last occurrence
                startIndex = Math.max(startIndex, charIndexMap.get(currentChar) + 1);
            }

            // Update the index of the current character
            charIndexMap.put(currentChar, endIndex);

            // Update the maximum length if needed
            maxLength = Math.max(maxLength, endIndex - startIndex + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String input = "pwwkew";
        int result = lengthOfLongestSubstring(input);
        System.out.println("Length of the longest substring without repeating characters: " + result);
    }
}
