package dsa.dynamicprogramming;

import java.util.Scanner;

public class CountSquareSubmatricesWithAll1s {
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
        System.out.println("Total number of square submatrices with all ones is "+countSquares(grid));
    }

    private static int countSquares(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1 && (i!=0 && j!=0)) {
                    mat[i][j] += Math.min(mat[i-1][j] , Math.min(mat[i-1][j-1] , mat[i][j-1]));
                }
                count += mat[i][j];
            }
        }
        return count;
    }
}