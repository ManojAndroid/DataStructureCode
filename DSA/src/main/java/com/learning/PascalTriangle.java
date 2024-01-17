package com.learning;

public class PascalTriangle {

  /*
  ( O(n^2) time and O(1) extra space )
  */
  static void printPascalTriangle1(int n) {
    for (int line = 1; line <= n; line++) {
      int c = 1;
      for (int i = 1; i <= line; i++) {
        System.out.print(c + " ");
        c = c * (line - i) / i;
      }
      System.out.println();
    }
  }

  public static void printPascalTriangle(int numRows) {
    for (int i = 0; i < numRows; i++) {
      int number = 1;
      for (int j = 0; j <= i; j++) {
        System.out.print(number + " ");
        number = number * (i - j) / (j + 1);
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int n = 5;
    printPascalTriangle(n);
  }
}
