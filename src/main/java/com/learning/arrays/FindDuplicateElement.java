package com.learning.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicateElement {
  // when find a number i, flip the number at position i-1 to negative.
  // if the number at position i-1 is already negative, i is the number that occurs twice.
  static  List<Integer> findDuplicates(int[] nums) {
      List<Integer> res = new ArrayList<>();
      for (int i = 0; i < nums.length; ++i) {
        int index = Math.abs(nums[i]) - 1;
        if (nums[index] < 0)
          res.add(Math.abs(index + 1));
        nums[index] = -nums[index];
      }
      return res;

  }

  public static void main(String[] args) {
    int arr[]={2,3,1,2,3};
    List<Integer> findDuplicates=findDuplicates(arr);

    for(Integer in:findDuplicates)
    {
      System.out.print(in+",");
    }

  }

}
