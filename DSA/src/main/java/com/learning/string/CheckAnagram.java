package com.learning.string;

import java.util.Arrays;

public class CheckAnagram {

  //Time Complexity: O(n)
  // Auxiliary Space: O(256) i.e. O(1) for constant space.

  static int NO_OF_CHARS = 256;
  //using sorting
  static boolean isAnagram(char [] s1, char []s2){
    int s1Length=s1.length;
    int s2Length=s2.length;
    if(s1Length!=s2Length)
      return false;
    Arrays.sort(s1);
    Arrays.sort(s2);

    for(int i=0;i<s1Length;i++)
    {
      if(s1[i]!=s2[i])
        return false;
    }
    return true;
  }
  static boolean areAnagram(String str1, String str2) {
    int count[] = new int[NO_OF_CHARS];
    if (str1.length() != str2.length()) {
      return false;
    }

    for (int i = 0; i < str1.length(); i++) {
      count[str1.charAt(i)]++;
      count[str2.charAt(i)]--;
    }

    for (int i = 0; i < NO_OF_CHARS; i++) {
      if (count[i] != 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String str1 = "gram";
    String str2 = "armg";

    // Function call
    if (areAnagram(str1, str2)) {
      System.out.print("The two strings are " +
          "anagram of each other");
    } else {
      System.out.print("The two strings are " +
          "not anagram of each other");
    }
  }
}
