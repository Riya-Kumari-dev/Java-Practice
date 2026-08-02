package dsa.dynamicprogramming;

import java.util.Arrays;

public class MatrixChainMultiplication {
    // min cost to multiply a matrix chain
    static void main(String[] args){
        int[] arr = {1,2,3,4,2}; // (1*2)(2*3)(3*4)(4*2) matrices => row*col of matrices
        System.out.println("Minimum cost to multiply "+ Arrays.toString(arr)+" matrix chain is "+matrixMultiplication(arr));
    }
    private static int matrixMultiplication(int arr[]){
        int n = arr.length;
        int[][] dp = new int[n-1][n-1]; // i -> 0 to n-2 and j bhi same
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<n-1; j++){
                if(i>=j) {
                    dp[i][j] = 0;
                    continue;
                }
                int minCost = Integer.MAX_VALUE;
                for(int k=i; k<j; k++){
                    int cost = arr[i] * arr[k+1]* arr[j+1];
                    int totalCost = dp[i][k] + dp[k+1][j] + cost;
                    minCost = Math.min(totalCost, minCost);
                }
                dp[i][j] =  minCost;
            }
        }
        return dp[0][n-2];
    }
    // memoization
//    private static int matrixMultiplication(int arr[]) {
//        int n = arr.length;
//        int[][] dp = new int[n-1][n-1]; // i -> 0 to n-2 and j bhi same
//        return MinCost(0, arr.length-2, arr, dp);
//    }
//    private static int MinCost(int i, int j, int[] arr, int[][] dp){
//        if(i==j) return 0;
//        if(dp[i][j] != 0) return dp[i][j];
//        int minCost = Integer.MAX_VALUE;
//        for(int k=i; k<j; k++){
//            int cost = arr[i] * arr[k+1]* arr[j+1];
//            int totalCost = MinCost(i,k, arr, dp) + MinCost(k+1,j, arr, dp) + cost;
//            minCost = Math.min(totalCost, minCost);
//        }
//        return dp[i][j] =  minCost;
//    }
    // recursion
//    private static int matrixMultiplication(int arr[]) {
//        return MinCost(0, arr.length-2, arr);
//    }
//    private static int MinCost(int i, int j, int[] arr){
//        if(i==j) return 0;
//        int minCost = Integer.MAX_VALUE;
//        for(int k=i; k<j; k++){
//            int cost = arr[i] * arr[k+1]* arr[j+1];
//            int totalCost = MinCost(i,k, arr) + MinCost(k+1,j, arr) + cost;
//            minCost = Math.min(totalCost, minCost);
//        }
//        return minCost;
//    }
}
