package com.learning;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindows1ContainsS2Substring {
    // Smallest window in a String containing all characters of other String
    //https://www.youtube.com/watch?v=e1HlptlipB0
    //  Time Complexity: O(n)
    // Space Complexity: O(1)
    public static String findMatchinSubstring(String s1, String pat) {
        Map<Character, Integer> mapPat = new HashMap<>();
        String ans = "";
        for (char ch : pat.toCharArray()) {
            mapPat.put(ch, mapPat.getOrDefault(ch, 0) + 1);
        }

        int mct = 0;
        int dmct = pat.length();// desiredMatchCount dmct
        Map<Character, Integer> mapS1 = new HashMap<>();
        int i = -1;
        int j = -1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            //acquire
            while (i < s1.length() - 1 && mct < dmct) {
                i++;
                char ch = s1.charAt(i);
                mapS1.put(ch, mapS1.getOrDefault(ch, 0) + 1);
                if (mapS1.getOrDefault(ch, 0) <= mapPat.getOrDefault(ch, 0)) {
                    mct++;
                }
                f1 = true;
            }
            // collect answer and release
            while (j < i && mct == dmct) {
                String pans = s1.substring(j + 1, i + 1);
                //collecting answer
                if (ans.isEmpty() || (ans.length() > pans.length())) {
                    ans = pans;
                }
                //releasing
                j++;
                char ch = s1.charAt(j);
                if (mapS1.getOrDefault(ch, 0) == 1) {
                    mapS1.remove(ch);
                } else {
                    mapS1.put(ch, mapS1.getOrDefault(ch, 0) + -1);
                }
                if (mapS1.getOrDefault(ch, 0) < mapPat.getOrDefault(ch, 0)) {
                    mct--;
                }
                f2 = true;
            }
            if (!f1 && !f2) {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String str1 = "this is a test string";
        String pattern1 = "tist";
        System.out.println(findMatchinSubstring(str1, pattern1));

        String str2 = "geeksforgeeks";
        String pattern2 = "ork";
        System.out.println(findMatchinSubstring(str2, pattern2));
    }
}
