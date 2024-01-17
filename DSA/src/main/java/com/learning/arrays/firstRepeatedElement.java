package com.learning.arrays;

import java.util.HashSet;
import java.util.Set;

public class firstRepeatedElement {

  public static int firstRepeated(int[] arr, int n) {

    Set<Integer> map = new HashSet<>();
    int index = -1;
    for (int i = n - 1; i >= 0; i--) {
      if (map.contains(arr[i])) {
        index = i;
      }
      map.add(arr[i]);
    }
    return index;
  }

  public static void main(String[] args) {
    int n = 7;
    int arr[] = {1, 5, 3, 4, 3, 5, 6};
    int result = firstRepeated(arr, n);
    System.out.println("value:"+arr[result]+" at index : "+result);
  }
}
