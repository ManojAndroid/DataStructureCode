package clientQuestion;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleSubsetsVVI {
    //https://leetcode.com/problems/subsets/
    //https://www.youtube.com/watch?v=3tpjp5h3M6Y
    // tc=O(n(2^n) and sc=O(n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    private void backTrack(List<List<Integer>> ans, List<Integer> tempSet, int[] nums, int start) {
        // add empty set in initial {} after element set;
        ans.add(new ArrayList<>(tempSet));
        for (int i = start; i < nums.length; i++) {
            // include the element
            tempSet.add(nums[i]);
            backTrack(ans, tempSet, nums, i + 1);//
            // exclude the element
            tempSet.remove(tempSet.size() - 1);
        }
    }

    public static void main(String[] args) {
       /* Example 1:

        Input: nums = [1,2,3]
        Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        Example 2:

        Input: nums = [0]
        Output: [[],[0]]*/
    }
}
