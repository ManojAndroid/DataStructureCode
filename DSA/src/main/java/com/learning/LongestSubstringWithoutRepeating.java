package com.learning;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s){
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLength = 0;
        int start = 0;
        HashMap<Character, Integer> charIndexMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (charIndexMap.containsKey(currentChar)) {
                // Move the start pointer to the next position after the previous occurrence
                start = Math.max(start, charIndexMap.get(currentChar) + 1);
            }

            // Update the character index in the map
            charIndexMap.put(currentChar, i);

            // Update the maximum length
            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }
    public static void main(String[] args) {
        String input = "abcabcbb";
        int result = lengthOfLongestSubstring(input);
        System.out.println("Length of the longest substring without repeating characters: " + result);
    }
}
