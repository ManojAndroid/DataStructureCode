package com.learning;

import java.util.Map;

public class MaximumProductSubarray {
/*
    This algorithm has a time complexity of O(n), where n is the length of the input array.
*/
    public static int maxProduct(int[] nums) {

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);
            result = Math.max(result, maxProduct);
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = {6, -3, -10, 0, 2};
        int result = maxProduct(nums);
        System.out.println("Maximum Product Subarray: " + result);
    }
}
