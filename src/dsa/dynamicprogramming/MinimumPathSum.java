package dsa.dynamicprogramming;

import java.util.Scanner;

public class MinimumPathSum {
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
        System.out.println("Minimum path sum is "+minPathSum(grid));
    }

    // TC = O(m*n) , AS = O(1)
    private static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0) continue;
                else if(i==0) grid[i][j] += grid[i][j-1];
                else if(j==0) grid[i][j] += grid[i-1][j];
                else {
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
        }
        return grid[m-1][n-1];
    }

    // tabulation
    // TC = O(m*n) , AS = O(m*n)
//    private static int minPathSum(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        int[][] dp = new int[m][n];
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(i==0 && j==0) dp[i][j] = grid[i][j];
//                else if(i==0) dp[i][j] = grid[i][j] + dp[i][j-1];
//                else if(j==0) dp[i][j] = grid[i][j] + dp[i-1][j];
//                else {
//                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
//                }
//            }
//        }
//        return dp[m-1][n-1];
//    }
}