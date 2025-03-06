package clientQuestion;

import java.util.ArrayList;
import java.util.List;

public class PrintSpiralMatrix {
    //https://leetcode.com/problems/spiral-matrix/description/
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int startR = 0, startC = 0;
        int row = matrix.length;
        int col = matrix[0].length;

        while (startR < row && startC < col) {
            for (int i = startC; i < col; i++) {
                result.add(matrix[startR][i]);
            }
            startR++;

            for (int i = startR; i < row; i++) {
                result.add(matrix[i][col - 1]);
            }
            col--;
            if (startR < row) {
                for (int i = col - 1; i >= startC; i--) {
                    result.add(matrix[row - 1][i]);
                }
                row--;
            }
            if (startC < col) {
                for (int i = row - 1; i >= startR; i--) {
                    result.add(matrix[i][startC]);
                }
                startC++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int a[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        // Function Call
        spiralOrder(a);
    }
}
