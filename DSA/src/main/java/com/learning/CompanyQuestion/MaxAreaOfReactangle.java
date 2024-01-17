package com.learning.CompanyQuestion;

public class MaxAreaOfReactangle {
//o(n)
  static int maxArea(int height[]) {
    int i = 0, j = height.length - 1;
    int result = Integer.MIN_VALUE;
    while (i < j) {
      int area = (j - i) * Math.min(height[i], height[j]);
      result = Math.max(result, area);
      if (height[i] < height[j]) {
        i++;
      } else {
        j--;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int arr[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int result = maxArea(arr);
    System.out.println(result);
  }

}
