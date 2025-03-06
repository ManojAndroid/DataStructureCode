package clientQuestion;

public class FindPeakElement {
    //https://leetcode.com/problems/find-peak-element/description/?envType=study-plan-v2&envId=top-interview-150
    // tc o(logn)
    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid + 1]) { // if mid is less than mid+1 remember
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
       /* Input: nums = [1,2,3,1]
        Output: 2
        Explanation: 3 is a peak element and your function should return the index number 2.*/
       int [] arrr={1,2,3,1};
        int [] arrr1={1,2,1,3,5,6,4};
        int res=findPeakElement(arrr);
        System.out.println("Res "+res);

    }
}
