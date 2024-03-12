package com.learning;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
  /*  Time complexity: O(m*n)
    Space complexity: O(m*n)*/
    public static int orangesRotting(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;

        int freshOranges=0;
        Queue<Coordinate> queue=new LinkedList<>();
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]==2){
                    queue.add(new Coordinate(i,j,0));
                }
                else if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }
        if(freshOranges==0)
            return 0;

        int [][] directions={{1,0},{0,-1},{-1,0},{0,1}};
        int result=-1;
        while(!queue.isEmpty() && freshOranges>0 )
        {
            Coordinate temp=  queue.remove();
            for(int [] direction:directions){
                int newRow=temp.x+direction[0];
                int newCol=temp.y+direction[1];

                if(newRow>=0 && newRow<row && newCol>=0 && newCol<col && grid[newRow][newCol]==1){
                    grid[newRow][newCol]=2;
                    queue.add(new Coordinate(newRow,newCol,temp.count+1));
                    freshOranges--;
                }
            }
            result=temp.count+1;
        }

        return freshOranges==0?result:-1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int result =orangesRotting(grid);
        System.out.println("Minutes to rot all oranges: " + result);
    }
}

class Coordinate {
    int count;
    int x, y;

    public Coordinate(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }

}
