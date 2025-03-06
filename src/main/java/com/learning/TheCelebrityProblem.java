package com.learning;

import java.util.Stack;

public class TheCelebrityProblem {
    static int celebrity(int[][] M, int n) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (know(M, a, b)) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }

        if (stack.isEmpty())
            return -1;
        int c = stack.pop();

        for (int i = 0; i < n; i++) {
            if (i != c && (know(M, c, i) || !know(M, i, c)))
                return -1;
        }
        return c;
    }

    private static boolean know(int[][] m, int i, int j) {
        return m[i][j] == 1;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] mat = {{0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}};
        System.out.println(celebrity(mat, n));
    }
}
