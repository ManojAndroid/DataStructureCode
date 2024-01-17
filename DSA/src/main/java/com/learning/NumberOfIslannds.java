package com.learning;

public class NumberOfIslannds {

    static int R=5;
    static int C=5;
    static int countIsland(int mat[][]){
        int count=0;
        boolean[][] visited =new boolean [R][C];

        for(int i=0;i<R;i++){
            for (int j=0;j<R;j++){
                if(mat[i][j]==1 && !visited[i][j]){
                    Dfs(mat,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void Dfs(int[][] mat, int i, int j, boolean[][] visited) {
    }

}
