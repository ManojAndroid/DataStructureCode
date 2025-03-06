package com.learning;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CheckValidSudoku {
    public static boolean isValidSudoku(String[][] board) {
        Set<String> strSet = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                String number = board[i][j];
                if (number != ".") {
                    if (!strSet.add(number + "is present in row" + i)
                            || !strSet.add(number + "is present in col" + j)
                            || !strSet.add(number + "is present in box" + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String[][] board = {
                {"5", "3", ".", ".", "7", ".", ".", ".", "."}
                , {"6", ".", ".", "1", "9", "5", ".", ".", "."}
                , {".", "9", "8", ".", ".", ".", ".", "6", "."}
                , {"8", ".", ".", ".", "6", ".", ".", ".", "3"}
                , {"4", ".", ".", "8", ".", "3", ".", ".", "1"}
                , {"7", ".", ".", ".", "2", ".", ".", ".", "6"}
                , {".", "6", ".", ".", ".", ".", "2", "8", "."}
                , {".", ".", ".", "4", "1", "9", ".", ".", "5"}
                , {".", ".", ".", ".", "8", ".", ".", "7", "9"}
        };
        System.out.println(isValidSudoku(board));
    }
}
