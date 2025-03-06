package com.learning;

public class LargestSumContiguousSubarray {

  static void maxValue(int arr[]) {

    int n = arr.length;
    int result = Integer.MIN_VALUE;
    int temp = 0;

    for (int i = 0; i < n; i++) {
      temp = temp + arr[i];
      if (temp > result)
        result = temp;
      if (temp < 0)
        temp = 0;
    }
    System.out.println(result);
  }


  public static void main(String[] args) {
    int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
    maxValue(a);
  }
}
