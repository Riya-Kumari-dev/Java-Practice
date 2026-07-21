package dsa.dynamicprogramming;

import java.util.Scanner;

public class UniquePaths2 {
    // You are given an m x n integer array grid. There is a robot initially located at  top left corner (i.e., grid[0][0]).
    // The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
    //An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows of the matrix : ");
        int m = sc.nextInt();
        System.out.print("Enter the number of columns of the matrix : ");
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        System.out.println("Enter " + (m * n) + " elements for the given matrix : ");
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.print("Number of possible unique paths that the robot can take to reach the bottom-right corner : "+uniquePathsWithObstacles(grid));
    }

    private static int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1) dp[i][j] = 0; // obstacle
                else if(i==0 && j==0) dp[i][j] = 1; // obstacle hota to upar hi pakda jata so no obstacle
                else if(j==0) dp[i][j] = dp[i-1][j]; // upar se
                else if(i==0) dp[i][j] = dp[i][j-1]; // left wala
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}