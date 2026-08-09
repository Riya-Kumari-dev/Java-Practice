package dsa.backtracking;

import java.util.Scanner;

import static dsa.backtracking.ValidSudoku.isValid;

public class SudokuSolver {
    /*Write a program to solve a Sudoku puzzle by filling the empty cells.

    A sudoku solution must satisfy all of the following rules:

    Each of the digits 1-9 must occur exactly once in each row.
    Each of the digits 1-9 must occur exactly once in each column.
    Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
    The '.' character indicates empty cells.*/
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[9][9];
        System.out.println("Fill the sudoku partially (given a n*n grid, for a blank, enter (.) : ");
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                board[i][j] = sc.next().charAt(0);
            }
        }
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        solveSudoku(board);
        System.out.println("Solved sudoku : ");
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static void solveSudoku(char[][] board) {
        int[] check = {0};
        solve(board, 0,0,  check);
    }
    private static void solve(char[][] board, int row, int col, int[] check){
        if(row == 9){
            check[0] = 1;
            return;
        }
        else if(board[row][col] != '.'){ // aage ki call
            if(col != 8) solve(board, row, col+1, check);
            else solve(board, row+1, 0, check);
        }
        else{ // board[row][col] == '.' // we have to fill
            for(char ch = '1'; ch<='9'; ch++){
                if(isValid(board, row, col, ch)){
                    board[row][col] = ch;
                    if(col != 8) solve(board, row, col+1,check);
                    else solve(board, row+1, 0, check);
                    if(check[0] == 1) return;
                    board[row][col] = '.'; // backtracking
                }
            }
        }
    }

}