package dsa.dynamicprogramming;

import java.util.Scanner;

public class VisitArrayPositionsToMaximiseScore {
    // You are initially at position 0 in the array, and you can visit other positions according to the following rules:
    //If you are currently in position i, then you can move to any position j such that i < j.
    //For each position i that you visit, you get a score of arr[i].
    //If you move from a position i to a position j and the parities of arr[i] and arr[j] differ, then you lose a score of x.
    //Return the maximum total score you can get.
    //Note that initially you have arr[0] points.

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter "+n+" elements for the array : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter x : ");
        int x = sc.nextInt();
        System.out.println("Maximum score we can get is "+maxScore(arr, x));
    }

    // memoization
    // TC = O(2*n), SC = O(2*n)
    private static long maxScore(int[] arr, int x) {
        long[][] dp = new long[arr.length][2];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++) dp[i][j] = -1;
        }
        return arr[0] + helper(1, arr, x, arr[0] % 2, dp); // initially arr[0] score and arr[0] %2 is the parity
    }
    private static long helper(int i, int[] arr, int x, int parity, long[][] dp){
        if(i==arr.length) return 0;
        if(dp[i][parity] != -1) return dp[i][parity];
        long skip = helper(i+1, arr, x, parity,dp);
        long take = arr[i] + helper(i+1, arr, x, arr[i] % 2, dp);
        if(arr[i] % 2 != parity) take -= x; // parities differ so subtract x
        return dp[i][parity] = Math.max(take, skip);
    }

    // recursion // time limit exceeded
//    private static long maxScore(int[] arr, int x) {
//        return arr[0] + helper(1, arr, x, arr[0]%2);
//    }
//    private static long helper(int i, int[] arr, int x, int parity){
//        if(i==arr.length) return 0;
//        long skip = helper(i+1, arr, x, parity);
//        long take = arr[i] + helper(i+1, arr, x, arr[i] % 2);
//        if(arr[i] % 2 != parity) take -= x; // parities differ so subtract x
//        return Math.max(take, skip);
//    }
}