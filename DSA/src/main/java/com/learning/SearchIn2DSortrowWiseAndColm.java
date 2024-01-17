package com.learning;

public class SearchIn2DSortrowWiseAndColm {

  /* Time Complexity: O(n), Only one traversal is needed, i.e, i from 0 to n and j from n-1 to 0 with at most 2*n steps. The above approach will also work for m x n matrix (not only for n x n). Complexity would be O(m + n).
   Auxiliary Space: O(1), No extra space is required.*/
  static void search(int mat[][], int n, int key) {
    int i = 0, j = n - 1;
    while (i < n && j >= 0) {
      if (mat[i][j] == key) {
        System.out.print("Element found at " +
            i + " " + j);
      }
      if (mat[i][j] > key) {
        j--;
      } else {
        i++;
      }
    }
  }

  public static void main(String[] args) {
    int mat[][] = {{10, 20, 30, 40},
        {15, 25, 35, 45},
        {27, 29, 37, 48},
        {32, 33, 39, 50}};

    search(mat, 4, 29);
  }

}
