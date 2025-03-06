package com.learning;

public class RotateMatrixBy90Degree {

    //1. transpose matrix
    //2. reverse matrix
    // time complexity=O(n2);
    // space(1
    public static void rotateMatrix(int[][] matrix) {

        int R = matrix.length;
        int C = matrix[0].length;
        //transpose matrix convert row int column and column into row
        for (int i = 0; i < R; i++) {
            for (int j = i + 1; j < C; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println("print transpose matrix");
        printMatrix(matrix);
        // reverse  transpose matrix

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][C - 1 - j];
                matrix[i][C - 1 - j] = temp;
            }
        }


    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        rotateMatrix(matrix);

        System.out.println("\nMatrix after 90-degree rotation:");
        printMatrix(matrix);
    }
}
