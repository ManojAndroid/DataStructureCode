package clientQuestion;

import java.util.HashMap;
import java.util.Map;

public class CheckIsIsomorphicStringOrNot {
    //https://leetcode.com/problems/isomorphic-strings/
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> charMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char original = s.charAt(i);
            char replacement = t.charAt(i);
            if (!charMap.containsKey(original)) {//check key
                if (!charMap.containsValue(replacement)) {//keep in mind check in value
                    charMap.put(original, replacement);
                } else {
                    return false;
                }
            } else {
                char mappedChar = charMap.get(original);
                if (mappedChar != replacement) {
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
     /*   Example 1:
        Input: s = "egg", t = "add"
        Output: true
        Example 2:
        Input: s = "foo", t = "bar"
        Output: false
        Example 3:
        Input: s = "paper", t = "title"
        Output: true*/
        String s = "paper";
        String t = "title";
        System.out.println(isIsomorphic(s,t));
    }
}
