package com.learning;

public class MaxRobberAmount {
  //Time Complexity: O(N)
//Auxiliary Space: O(1),
  public static int maxValur(int hvalue[], int n) {

    if (n == 0) {
      return 0;
    }

    int value1 = hvalue[0];
    if (n == 1) {
      return value1;
    }

    int value2 = Math.max(value1, hvalue[1]);
    if (n == 2) {
      return value2;
    }

    int maxValue = 0;
    for (int i = 2; i < n; i++) {
      maxValue = Math.max((value1 + hvalue[i]), value2);
      value1 = value2;
      value2 = maxValue;
    }
    return maxValue;
  }

  public static void main(String[] args) {
    int hval[] = {6, 7, 1, 3, 8, 2, 4};
    int n = hval.length;
    System.out.println("Maximum loot value : " + maxValur(hval, n));
  }

}
