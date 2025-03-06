package com.learning.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountPairsWithGivenSum {

  static int count(int arr[], int k) {
    HashMap<Integer, Integer> m = new HashMap<>();
    int count = 0;
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      if (m.containsKey(k - arr[i])) {
        count += m.get(k - arr[i]);
      }
      if (m.containsKey(arr[i])) {
        m.put(arr[i], m.get(arr[i]) + 1);
      } else {
        m.put(arr[i], 1);
      }
    }
    return count;

}

  public static void main(String[] args) {
    int arr[] = {1, 5, 7, 1};
    int result = count(arr, 6);
    System.out.println(result);
  }

}
