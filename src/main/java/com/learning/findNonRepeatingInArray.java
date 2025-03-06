package com.learning;

public class findNonRepeatingInArray {
//XOR of a number with itself is 0.
//XOR of a number with 0 is the number.
  //Time Complexity: O(n).
//Space Complexity: O(1).
  static void findNonRepeating(int arr[], int n) {
    int result = 0;
    for (int i = 0; i < n; i++) {
      result = result ^ arr[i];
    }
    System.out.println("result" + result);
  }

  public static void main(String[] args) {
    int []arr = {3, 8, 3, 2, 2, 1, 1};
    int n = arr.length;
    findNonRepeating(arr, n);
  }
}
