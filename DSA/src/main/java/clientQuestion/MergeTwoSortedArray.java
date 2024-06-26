package clientQuestion;

public class MergeTwoSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        // Merge nums1 and nums2 from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // Copy remaining elements from nums2 if any
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

    }

    public static void main(String[] args) {
       /* Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        Output: [1,2,2,3,5,6]*/
       /* int [] nums1 = {1,2,3,0,0,0};
        int m=3;
        int [] nums2 = {2,5,6};
        int n=3;
        merge(nums1,m,nums2,n);*/
        int [] arr={-2,1,-4,5,3};
        findSum(arr,arr.length);
        System.out.println();
    }

    public static int findSum(int A[],int N)
    {
        int min=A[0];
        int max=A[0];
        for(int i=0;i<N;i++)
        {
            min=Math.min(min,A[i]);
            max=Math.max(max,A[i]);
        }
        return max-min;

    }
}
