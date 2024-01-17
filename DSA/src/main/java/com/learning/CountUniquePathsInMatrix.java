package com.learning;

public class CountUniquePathsInMatrix {
    //Count all possible paths from top left to bottom right of a mXn matrix
/*    Time Complexity: O(M * N) – Due to nested for loops.
    Auxiliary Space: O(M * N) – We have used a 2D array of size M x N*/
    public static void countUniquePath(int m, int n) {
        int[][] count = new int[m][n];

        for (int i = 0; i < m; i++) {
            count[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            count[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                count[i][j] = count[i - 1][j] + count[i][j-1];
            }
        }
        System.out.println(count[m - 1][n - 1]);
    }

    public static void main(String[] args) {
        countUniquePath(3, 3);
    }
}
