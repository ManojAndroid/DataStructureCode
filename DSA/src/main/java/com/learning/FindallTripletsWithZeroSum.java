package com.learning;

import java.util.*;

public class FindallTripletsWithZeroSum {
    /*Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
    such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
*/
    /*Complexity
    Time complexity: O(N^log N)
    Space complexity: O(N)*/
    public static List<List<Integer>> findTriplets(int nums[]) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int st = i + 1;
            int en = nums.length - 1;

            while (st < en) {
                int sum = nums[i] + nums[st] + nums[en];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[st], nums[en]));
                    st++;
                    en--;

                    while (st < en && nums[st] == nums[st - 1]) {
                        st++;
                    }

                    while (st < en && nums[en] == nums[en + 1]) {
                        en--;
                    }
                } else if (sum < 0) {
                    st++;
                } else {
                    en--;
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int arr[] = {0, -1, 2, -3, 1};
        int n = arr.length;
        /*Input: nums = [-1,0,1,2,-1,-4]
        Output: [[-1,-1,2],[-1,0,1]]*/
        findTriplets(arr);
    }
}
