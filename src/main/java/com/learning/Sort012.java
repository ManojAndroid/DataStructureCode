package com.learning;

public class Sort012 {
  /*Time Complexity: O(n).
  Only one traversal of the array is needed.
  Space Complexity: O(1).
  No extra space is required.*/
  static void sort(int arr[], int n) {
    int low = 0, mid = 0, temp = 0;
    int hi = arr.length - 1;

    while (mid <= hi) {
      switch (arr[mid]) {
        case 0: {
          temp = arr[low];
          arr[low] = arr[mid];
          arr[mid] = temp;
          low++;
          mid++;
          break;
        }
        case 1: {
          mid++;
          break;
        }
        case 2: {
          temp = arr[mid];
          arr[mid] = arr[hi];
          arr[hi] = temp;
          hi--;
        }
      }
    }
    for(int i=0;i<n;i++){
      System.out.print(arr[i]+" , ");
    }
  }

  public static void main(String[] args) {
    int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
    int arr_size = arr.length;
    sort(arr, arr_size);
  }
}
