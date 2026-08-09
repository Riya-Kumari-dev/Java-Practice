package dsa.backtracking;

import java.util.Scanner;

public class MaxKnightsPlaced {
    static int max;
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the chessboard : ");
        int n = sc.nextInt();
        max = 0;
        maxKnightsPlaced(n);
        System.out.println("Maximum number of knights that can be placed in a "+n+"*"+n+" chessboard is "+max);
    }
    private static void maxKnightsPlaced(int n) {
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = 'X';
            }
        }
        helper(board, 0,0,0);
    }
    static void helper(char[][] board, int row, int col, int count){
        int m = board.length;
        if(row == m) { // base case
            max = Math.max(max, count);
            return;
        }
        else if(isSafe(board, row, col)){
            board[row][col] = 'K';
            if(col!=m-1) helper(board, row, col+1, count +1);
            else helper(board, row+1, 0, count +1);
            board[row][col] = 'X'; // backtracking
        }
        if(col!=m-1) helper(board, row, col+1, count);
        else helper(board, row+1, 0, count);

    }
    static boolean isSafe(char[][] board, int row, int col){
        int n = board.length;
        int[] r = {-2,-2,-1,-1,1,1,2,2};
        int[] c = {1,-1,2,-2,2,-2,1,-1};
        for(int i=0; i<8; i++){
            int k = row + r[i];
            int j = col+c[i];
            if(k>=0 && k<n && j>=0 && j<n && board[k][j] == 'K'){
                return false;
            }
        }
        return true;
    }
}
