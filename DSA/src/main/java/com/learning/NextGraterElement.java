package com.learning;

import java.util.Stack;

public class NextGraterElement {

  public static int[] nextElement(int arr[], int n) {
    int arr1[] = new int[n];
    Stack<Integer> stack = new Stack<>();
    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() <= arr[i]) {
        stack.pop();
      }

      arr1[i] = stack.isEmpty() ? arr[i] : stack.peek();
      stack.push(arr[i]);
    }
    return arr1;
  }

  public static void main(String[] args) {
    int arr[] = {11, 13, 21, 3};
    int[] result = nextElement(arr, arr.length);

    for (int value : result) {
      System.out.println(value + " ");
    }
  }
}
