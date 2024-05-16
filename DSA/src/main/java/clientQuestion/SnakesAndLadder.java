package clientQuestion;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadder {
    //https://leetcode.com/problems/snakes-and-ladders/description/?envType=study-plan-v2&envId=top-interview-150
    // t and c o(n*n)
    public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        int step = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        queue.add(1);// start from 1
        visited[n - 1][0] = true;// mark 1 coordinate visited
        int maxPos = n * n; // Calculate n*n only once
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int x = queue.poll();
                if (x == maxPos)
                    return step;// reached to final destination
                for (int dice = 1; dice <= 6; dice++) {
                    int newPosition = x + dice;
                    if (newPosition > maxPos)
                        break;
                    int[] pos = findCoordinate(newPosition, n);
                    int r = pos[0];
                    int c = pos[1];
                    if (!visited[r][c]) {
                        visited[r][c] = true;
                        if (board[r][c] == -1) {
                            queue.add(newPosition);// add new position
                        } else {
                            queue.add(board[r][c]);// if snake or ladder
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private static int[] findCoordinate(int currPos, int n) {
        int r = n - 1 - (currPos - 1) / n;
        int c = (currPos - 1) % n;
        if (r % 2 == n % 2) {// if row and n is even then c value will change
            return new int[]{r, n - 1 - c};
        } else {
            return new int[]{r, c};
        }
    }

    public static void main(String[] args) {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int step = snakesAndLadders(board);
        System.out.println("step " + step);
    }
}
