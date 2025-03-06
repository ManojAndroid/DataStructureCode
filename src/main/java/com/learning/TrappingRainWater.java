package com.learning;

public class TrappingRainWater {

  /* Time Complexity: O(n).
   Only one traversal of the array is needed, So time Complexity is O(n).
   Space Complexity: O(n).*/
  static void waterRainTrapping(int arr[], int n) {

    int left[] = new int[n];
    int right[] = new int[n];

    left[0] = arr[0];
    for (int i = 1; i < n; i++) {
      left[i] = Math.max(left[i - 1], arr[i]);
    }

    right[n - 1] = arr[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      right[i] = Math.max(right[i + 1], arr[i]);
    }
    int water = 0;
    for (int i = 0; i < n; i++) {
      water += Math.min(left[i], right[i]) - arr[i];
    }
    System.out.println("water trapped: "+water);

  }
  /* Time Complexity: O(n).
  Only one traversal of the array is needed, So time Complexity is O(n).
  Space Complexity: O(1).*/
  public int trap(int[] height) {
    int n = height.length;
    int leftMax = height[0];
    int rightMax = height[n - 1];
    int l = 0;
    int r = n - 1;
    int ans = 0;
    while (l < r) {
      if (leftMax < rightMax) {
        l++;
        leftMax = Math.max(leftMax, height[l]);
        ans += leftMax - height[l];
      } else {
        r--;
        rightMax = Math.max(rightMax, height[r]);
        ans += rightMax - height[r];
      }
    }
    return ans;
  }

    public static void main(String[] args) {
    int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    waterRainTrapping(arr, arr.length);
  }
}
