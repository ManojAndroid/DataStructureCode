package com.learning.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

  //Time Complexity: O(N), Traversing over the string of size N
  //Auxiliary Space: O(256), To store the frequency of the characters in the string.
  static int nonRepeatingFirstChar(String str) {
    char[] chars = new char[256];
    for (int i = 0; i < str.length(); i++) {
      chars[str.charAt(i)]++;
    }
    int index = -1;
    int i;
    for (i = 0; i < str.length(); i++) {
      if (chars[str.charAt(i)] == 1) {
        index = i;
        break;
      }
    }
    return index;
  }

  public static char findFirstNonRepeatingCharacter(String s) {
    Map<Character, Integer> charFrequency = new LinkedHashMap<>();

    // Count the frequency of each character
    for (char c : s.toCharArray()) {
      charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
    }

    // Find the first non-repeating character
    for (char c : s.toCharArray()) {
      if (charFrequency.get(c) == 1) {
        return c;
      }
    }

    // If there is no non-repeating character, return a default value (e.g., '\0')
    return '\0';
  }

  public static void main(String[] args) {
    String str = "geeksforgeeks";
    int index = nonRepeatingFirstChar(str);

    System.out.println(
        index == -1
            ? "Either all characters are repeating or string "
            + "is empty"
            : "First non-repeating character is "
                + str.charAt(index));
  }
}
