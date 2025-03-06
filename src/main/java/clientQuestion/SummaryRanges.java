package clientQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();

        if (nums.length == 1) {
            ans.add(nums[0] + "");
            return ans;
        }
        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            end = end + 1;
            if (end != nums[i]) {
                if (end - 1 != start) {
                    ans.add(start + "->" + (end - 1));
                } else {
                    ans.add(start + "");
                }
                start = nums[i];
                end = nums[i];

            }
            if (i == nums.length - 1) {
                if (end != start) {
                    ans.add(start + "->" + (end));
                } else {
                    ans.add(start + "");
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 4, 6, 8, 9};
        System.out.println(summaryRanges(arr));
        System.out.println("end");
    }
}
