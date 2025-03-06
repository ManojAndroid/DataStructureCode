package clientQuestion;

public class MinimumSizeSubarraySum {
    //https://leetcode.com/problems/minimum-size-subarray-sum/?envType=study-plan-v2&envId=top-interview-150
    //Time complexity:
    //O(n)
    //
    //Space complexity:
    //O(1)
    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        //int minLen =Integer.MAX_VALUE;
        int minLen =0;
        int currentSum = 0;

        while (r < nums.length) {
            currentSum += nums[r];
            while (l <= r && currentSum >= target) {
                minLen = Math.min(minLen, r - l + 1);
                currentSum -= nums[l++];
            }
            r++;
        }
       // return minLen==Integer.MAX_VALUE?0:minLen;
        return minLen;
    }

    public static void main(String[] args) {
       /* Input: target = 7, nums = [2,3,1,2,4,3]
        Output: 2
        Explanation: The subarray [4,3] has the minimal length under the problem constraint.
        Example 2:

        Input: target = 4, nums = [1,4,4]
        Output: 1
        Example 3:

        Input: target = 11, nums = [1,1,1,1,1,1,1,1]
        Output: 0*/
        int []  nums = {1,1,1,1,1,1,1,1};
        System.out.println("result ;"+minSubArrayLen( 11,nums));

    }
}