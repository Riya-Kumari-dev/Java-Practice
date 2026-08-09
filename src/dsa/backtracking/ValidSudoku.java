package dsa.backtracking;

import java.util.Scanner;

public class ValidSudoku {
    /*Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
    Note:

    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.*/

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] grid = new char[9][9];
        System.out.println("Fill the sudoku partially (given a n*n grid, for a blank, enter (.) : ");
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                grid[i][j] = sc.next().charAt(0);

            }
        }
        if(isValidSudoku(grid)) System.out.println("Yes, the given sudoku is valid.");
        else System.out.println("No, the given sudoku is not valid.");
    }
    private static boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.')continue;
                char num = board[i][j];
                board[i][j] = '.';
                if(!isValid(board, i, j, num)) return false;
                board[i][j] = num;
            }
        }
        return true;
    }
    public static boolean isValid(char[][] board, int row, int col, char num){
        // check row
        for(int j=0; j<9; j++){
            if(board[row][j] == num) return false;
        }
        // check col
        for(int i=0; i<9; i++){
            if(board[i][col] == num) return false;
        }
        // check grid
        int sRow = row/3*3;
        int sCol = col/3*3;
        for(int i=sRow; i<sRow+3; i++){
            for(int j=sCol; j<sCol+3; j++){
                if(board[i][j] == num) return false;
            }
        }
        return true;
    }

}
