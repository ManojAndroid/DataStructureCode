package com.learning.arrays;

import java.util.HashSet;
import java.util.Set;

public class TripletSumArray {
  //Time complexity: O(N^2)
  //Auxiliary Space: O(N), since n extra space has been taken.
  public static void find3Numbers(int a[], int n, int x) {
    for (int i = 0; i < n - 2; i++) {
      Set<Integer> set = new HashSet<>();
      for (int j = i + 1; j < n; j++) {
        int temp = x - a[i] - a[j];
        if (set.contains(temp)) {
          System.out.println("A[i]:"  + a[i] + "A[j]: " + a[j] + "A[k]: " + temp);
        }
        set.add(a[j]);
      }

    }
  }

  public static void main(String[] args) {
    int n = 6, X = 13;
    int arr[] = {1, 4, 45, 6, 10, 8};
    find3Numbers(arr, n, X);
  }

}
