package clientQuestion;

import java.util.*;

public class GroupAnagram {
    //https://leetcode.com/problems/group-anagrams/description/
    // time complexity is O(n * klogk).where k is the length of the longest string.
    // space complexity is O(n * k).
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mapList = new HashMap<>();
        for (String str : strs) {
            char [] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String sortedString = new String(strArray);
            if (mapList.containsKey(sortedString)) {
                mapList.get(sortedString).add(str);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                mapList.put(sortedString, newList);
            }
        }
        return new ArrayList<>(mapList.values());
    }

    public static void main(String[] args) {
        /*Example 1:
        Input: strs = ["eat","tea","tan","ate","nat","bat"]
        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]*/
    }
}
