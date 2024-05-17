package clientQuestion;

public class FindMinimumInSortedRottedArray {
    //https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
    // tc o(logn)
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == nums[end]) {// remember if there are duplicate no else remove this code
                end--;
            } else if (nums[mid] > nums[end]) {// remember
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];// return index for pivote element
    }

    public static void main(String[] args) {
       /* Example 1:

        Input: nums = [1,3,5]
        Output: 1
        Example 2:

        Input: nums = [2,2,2,0,1]
        Output: 0*/
    }
}
