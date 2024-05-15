package clientQuestion;

public class SolveSudoku {
    //https://leetcode.com/problems/sudoku-solver/description/
    //https://www.youtube.com/watch?v=FWAIf_EVUKE
    public void solveSudoku(char[][] board) {
        if(board==null || board.length==0)
            return;
        solver(board);

    }
    private boolean solver(char [][] board){

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){

                    for(char c='1';c<='9';c++){// try for all from 1 to 9
                        if(isValid(board,i,j,c)){
                            board[i][j]=c;//put c for this cell;

                            if(solver(board))//If it's the solution return true
                                return true;
                            else
                                board[i][j]='.';//Otherwise go back
                        }
                    }
                    return false;// if not valid then return false
                }
            }
        }
        return true;// if valud return true call stack
    }

    private boolean isValid(char [][] board, int row,int col,char c){

        for(int i=0;i<9;i++){
            if(board[i][col]!='.' && board[i][col]==c)// checking for row
                return false;
            if(board[row][i]!='.' && board[row][i]==c)// checking for col
                return false;
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]!='.' && board[3*(row/3)+i/3][3*(col/3)+i%3]==c)//
                return false;
        }
        return true;
    }
}
