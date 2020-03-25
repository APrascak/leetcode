// Valid Sudoku
// 25 March 2020

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] validate = new int[9];
        for(int i = 0; i < 9; i++) {
            validate[i] = 0;
        }
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') { // if there's a number
                    if (validate[Integer.parseInt(String.valueOf(board[i][j])) - 1] == 0) {
                        validate[Integer.parseInt(String.valueOf(board[i][j])) - 1]++;
                    } else {
                        return false;
                    }
                }
            }
            for(int k = 0; k < 9; k++) {
                validate[k] = 0;
            } 
        }
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] != '.') { // if there's a number
                    if (validate[Integer.parseInt(String.valueOf(board[j][i])) - 1] == 0) {
                        validate[Integer.parseInt(String.valueOf(board[j][i])) - 1]++;
                    } else {
                        return false;
                    }
                }
            }
            for(int k = 0; k < 9; k++) {
                validate[k] = 0;
            } 
        }
        for(int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                for (int l = i; l < i+3; l++) { 
                    for (int k = j; k < j+3; k++) {
                        if (board[l][k] != '.') {
                            if (validate[Integer.parseInt(String.valueOf(board[l][k])) - 1] == 0) {
                                validate[Integer.parseInt(String.valueOf(board[l][k])) - 1]++;
                            } else {
                                return false;
                            }
                        }
                    }
                }
                for(int k = 0; k < 9; k++) {
                    validate[k] = 0;
                } 
            }
        }
        return true;
    }
}