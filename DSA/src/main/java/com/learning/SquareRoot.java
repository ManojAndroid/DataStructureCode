package com.learning;

public class SquareRoot {
  //Time Complexity: O(log(X)).
 // Auxiliary Space: O(1).
  static int squareRoot(int x) {
    int start = 0, end = x / 2, ans = 0;

    while (start <= end) {
      int mid = (start + end) / 2;
      if (mid * mid == x) {
        return mid;
      }
      if (mid * mid < x) {
        start = mid + 1;
        ans = mid;
      } else {
        end = mid - 1;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int x = 65;
    System.out.println(squareRoot(x));
  }

}
