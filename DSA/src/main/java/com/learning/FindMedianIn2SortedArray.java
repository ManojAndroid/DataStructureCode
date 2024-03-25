package com.learning;

public class FindMedianIn2SortedArray {
    //https://www.youtube.com/watch?v=I8zyhfqIx8k
    public static  double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        // Ensure nums1 is the smaller array for simplicity
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int start=0;
        int end=n1;
        while(start<=end){
            int part1=(start+end)/2;
            int part2=(n1+n2+1)/2-part1;
            int maxLeftNums1=part1==0?Integer.MIN_VALUE:nums1[part1-1];
            int maxLeftNums2=part2==0?Integer.MIN_VALUE:nums2[part2-1];
            int minRightNums1=part1==n1?Integer.MAX_VALUE:nums1[part1];
            int minRightNums2=part2==n2?Integer.MAX_VALUE:nums2[part2];
            if(maxLeftNums1<=minRightNums2 && maxLeftNums2<=minRightNums1)
            {
                if((n1+n2)%2==0){
                    return (Math.max(maxLeftNums1,maxLeftNums2)
                            +Math.min(minRightNums1,minRightNums2))/2.0;
                }
                else{
                    return Math.max(maxLeftNums1,maxLeftNums2);
                }
            }
            else if(maxLeftNums1>minRightNums2){
                end=part1-1;
            }
            else{
                start=part1+1;
            }

        }
        return 0;
    }

    public static void main(String[] args) {
       /* Example 1:
        Input: nums1 = [1,3], nums2 = [2]
        Output: 2.00000
        Explanation: merged array = [1,2,3] and median is 2.
        Example 2:
        Input: nums1 = [1,2], nums2 = [3,4]
        Output: 2.50000
        Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.*/
        int [] nums1 = {1,3};
        int []nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
