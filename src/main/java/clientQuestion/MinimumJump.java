package clientQuestion;

public class MinimumJump {
    //https://leetcode.com/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-interview-150
   //tc O(n)
    //sc (1);
    // youtube link for ref  https://www.youtube.com/watch?v=9kyHYVxL4fw
    public int jump(int[] nums) {
        int jumpCount = 0;
        int coverage = 0;
        int destination = nums.length - 1;
        int lastCoverageIndx = 0;
        if (nums.length == 1)//base case
            return jumpCount;

        for (int i = 0; i < nums.length; i++) {
            coverage = Math.max(coverage, i + nums[i]);
            if (i == lastCoverageIndx) {
                lastCoverageIndx = coverage;
                jumpCount++;

                if (coverage >= destination) {
                    return jumpCount;
                }
            }
        }
        return jumpCount;

    }

    public static void main(String[] args) {
      /*  Input: nums = [2,3,1,1,4]
        Output: 2
        Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
                Example 2:
        Input: nums = [2,3,0,1,4]
        Output: 2*/

    }
}
