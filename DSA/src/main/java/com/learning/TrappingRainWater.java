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

  public static void main(String[] args) {
    int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    waterRainTrapping(arr, arr.length);
  }
}
