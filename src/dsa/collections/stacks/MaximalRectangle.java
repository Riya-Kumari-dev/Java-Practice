package dsa.collections.stacks;

import java.util.Scanner;

import static dsa.collections.stacks.LargestRectangleInHistogram.largestRectangleArea;

public class MaximalRectangle {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the rows of the matrix : ");
        int m = sc.nextInt();
        System.out.print("Enter the columns of the matrix : ");
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        System.out.print("Enter " + (n * m) + " elements for the binary matrix only 1s and 0s : ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int ans = maximalRectangle(arr);
        System.out.println("Largest rectangle formed using only 1s " + ans);
    }

    private static int maximalRectangle(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        for(int j=0; j<m; j++){
            for(int i=1; i<n; i++){
                if(mat[i][j] != 0) mat[i][j] += mat[i-1][j];
            }
        }
        int mx = Integer.MIN_VALUE;
        for(int[] row : mat){
            int area = largestRectangleArea(row);
            if(mx<area) mx = area;
        }
        return mx;
    }
}
