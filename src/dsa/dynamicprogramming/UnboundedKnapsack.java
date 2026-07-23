package dsa.dynamicprogramming;

import java.util.Scanner;

public class UnboundedKnapsack {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total number of items available : ");
        int n = sc.nextInt();
        int[] val = new int[n];
        int[] wt = new int[n];
        System.out.print("Enter values of each item (total " + n + " items) : ");
        for(int i=0; i<n; i++) val[i] = sc.nextInt();

        System.out.print("Enter weight of each item (total " + n + " items) : ");
        for(int i=0; i<n; i++) wt[i] = sc.nextInt();

        System.out.print("Enter the capacity that the sack can hold : ");
        int w = sc.nextInt();
        System.out.println("The maximum profit the thief can make is "+knapsack(w, val, wt));
    }
//    Given a set of items, each with a weight and a value, represented by the array wt[] and val[] respectively.
//    Also, a knapsack with a weight limit capacity.
//    Your task is to fill the knapsack in such a way that we can get the maximum profit. Return the maximum profit.
//    Note: Each item can be taken any number of times.

    // TC = O(n*W) and AS = O(n*w)
    private static int knapsack(int w, int[] val, int[] wt) {
        // i -> 0 to n-1 and W -> W to 0
        int n = val.length;
        int[][] dp = new int[n][w+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++) dp[i][j] = -1;
        }
        return profit(w, val, wt, 0, dp);
    }
    private static int profit(int capacity, int[] val, int[] wt, int idx, int[][] dp){
        if(idx == val.length) return 0;
        if(dp[idx][capacity] != -1) return dp[idx][capacity];
        int skip = profit(capacity, val, wt, idx+1, dp);
        if(capacity < wt[idx]) return dp[idx][capacity] = skip;
        int pick = val[idx] + profit(capacity-wt[idx], val, wt, idx, dp); // unlimited son no idx+1
        return dp[idx][capacity] = Math.max(pick, skip);
    }
}