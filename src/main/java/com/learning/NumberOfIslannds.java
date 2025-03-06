package com.learning;

public class NumberOfIslannds {

    static int R;
    static int C;

    static int countIsland(int mat[][]) {
        R = mat.length;
        C = mat[0].length;
        int count = 0;
        boolean[][] visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (mat[i][j] == 1 && !visited[i][j]) {
                    Dfs(mat, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void Dfs(int[][] mat, int i, int j, boolean[][] visited) {

        int[] nbrRow = {1, 1, 1, 0, -1, -1, -1, 0};
        int[] nblClm = {1, 0, -1, -1, -1, 0, 1, 1};
        visited[i][j] = true;
        for (int k = 0; k < 8; k++) {
            if (isValid(i + nbrRow[k], j + nblClm[k], mat, visited)) {
                Dfs(mat, i + nbrRow[k], j + nblClm[k], visited);
            }
        }


    }

    private static boolean isValid(int r, int c, int[][] mat, boolean[][] visited) {
        return (r >= 0 && R > r && c >= 0 && C > c && mat[r][c] == 1 && !visited[r][c]);
    }

    public static void main(String[] args) {
        int M[][] = {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};
        System.out.println("Number of islands is: " + countIsland(M));
    }

}
