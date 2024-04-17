package com.learning;

public class RowWithMax1s {
   /* Time Complexity: O(m log n) where m is the number of rows and n is the number of columns in the matrix.
    Auxiliary Space:  O(log n), as implicit stack is created due to recursion.*/
    public static int rowWithMax1s(int [][] m) {

        int ResultIndex = 0, count = 0;
        int r = m.length;
        int c = m[0].length;

        for (int i = 0; i < r; i++) {
            int first1Index = findFirst1(m[i], 0, c-1);
            if (first1Index != -1 && c - first1Index > count) {
                count = c - first1Index;
                ResultIndex = i;
            }
        }
        return ResultIndex;
    }

    private static int findFirst1(int[] m, int strt, int end) {
        if (strt <= end) {
            int mid = strt+(end - strt) / 2;
            if ((mid == 0 || (m[mid - 1] == 0)) && m[mid] == 1)//
                return mid;
            else if (m[mid] == 0) {
                return findFirst1(m, (mid + 1), end);
            } else {
                return findFirst1(m, strt, (mid - 1));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int mat[][] = { {0,0,0,1,1,1,1,1,1},
                {0,0,0,0,1,1,1,1,1},
                {0,0,0,0,1,1,1,1,1}};
        System.out.println("Index of row with maximum 1s is "+rowWithMax1s(mat));
    }
}
