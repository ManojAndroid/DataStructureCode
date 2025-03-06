package clientQuestion;

public class MissingNumberFinder {

    public static void findOneMissingNumber(int[] nums) {
        int n = nums.length;
        int expetedSum = (n + 1) * (nums[0] + nums[n - 1]) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        System.out.println("Missing Number : "+(expetedSum - actualSum));

    }

    public static void findNMissingNumber(int[] nums) {
        int n = nums.length;
        int value=nums[0];
      for(int i=1;i<n;i++){
          value=value+1;
          if(value!=nums[i]){
              System.out.println("Missing Number"+value);
              i--;
          }
      }
    }

    public static void main(String[] args) {
        /*int[] nums1 = {1, 2, 3, 4, 6};
        findOneMissingNumber(nums1);
        System.out.println("---------");
        int[] nums2 = {3, 4, 5, 6, 7, 9};
        findOneMissingNumber(nums2);*/
        System.out.println("findNMissingNumber");
        int[] nums3 = {3, 4, 5, 6, 7, 9,13};
        findNMissingNumber(nums3);
    }
}
