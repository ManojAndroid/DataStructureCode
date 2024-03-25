package clientQuestion;

import java.util.HashMap;
import java.util.Map;

public class TargetSumIndices {
    //Given an array of integers nums and an integer target,
    // return indices of the two numbers such that they add up to target.
    //https://leetcode.com/problems/two-sum/
    public static  int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> ValueIndeMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (ValueIndeMap.containsKey(temp)) {
                return new int[] { ValueIndeMap.get(temp), i };
            }
            ValueIndeMap.put(nums[i], i);
        }
        return new int[] {};

    }

    public static void main(String[] args) {

    }
}
