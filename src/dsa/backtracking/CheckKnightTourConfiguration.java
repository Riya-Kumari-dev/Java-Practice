package dsa.backtracking;

import java.util.Scanner;

public class CheckKnightTourConfiguration {
//     There is a knight on an n x n chessboard.
//     In a valid configuration, the knight starts at the top-left cell of the board and visits every cell on the board exactly once.
//    You are given an n x n integer matrix grid consisting of distinct integers from the range [0, n * n - 1]
//     where grid[row][col] indicates that the cell (row, col) is the grid[row][col]th cell that the knight visited. The moves are 0-indexed.
//    Return true if grid represents a valid configuration of the knight's movements or false otherwise.
//    Note that a valid knight move consists of moving two squares vertically and one square horizontally, or two squares horizontally and one square vertically.
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the chessboard : ");
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        System.out.println("Enter the knight's paths (0 to "+(n*n-1)+") : ");
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        if(checkValidGrid(grid)) System.out.println("Yes, the given grid represents valid configuration of the knight's movements.");
        else System.out.println("No, the given grid doesn't represents valid configuration of the knight's movements.");
    }

    private static boolean checkValidGrid(int[][] grid) {
        if(grid[0][0] != 0) return false;
        return valid(grid,0,0,0);
    }
    public static boolean valid(int[][] grid, int num, int row, int col){
        int n = grid.length;
        if(grid[row][col] == n*n-1) return true; // base case
        int[] r = {-2,-2,-1,-1,1,1,2,2};
        int[] c = {1,-1,2,-2,2,-2,1,-1};
        for(int i=0; i<8; i++){
            int k = row + r[i];
            int j = col+c[i];
            if(k>=0 && k<n && j>=0 && j<n && grid[k][j] == num +1){
                return valid(grid, num +1,k, j);
            }
        }
        return false;
    }
}
