package dsa.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how many types of coins available : ");
        int n = sc.nextInt();
        int[] coins = new int[n];
        System.out.print("Enter "+n+" coins type : ");
        for(int i=0; i<n; i++){
            coins[i] = sc.nextInt();
        }
        System.out.print("Enter the amount to be count : ");
        int amount = sc.nextInt();
        int ans = coinChange(coins, amount);
        if(ans == -1) System.out.println(amount+" cannot be make up using the "+ Arrays.toString(coins)+" coins");
        else System.out.println("Minimum number of coins needed to make up "+amount+" from "+Arrays.toString(coins)+" is "+ans);
    }

    // tabulation
    private static int coinChange(int[] coins, int amount) {
        long[][] dp = new long[coins.length][amount+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                long skip = (i>0) ? dp[i-1][j] : ((j==0) ? 0 : Integer.MAX_VALUE);// skip = helper(coins, i + 1, amount, dp);
                if(coins[i] > j) dp[i][j] = skip;
                else{
                    //int take = helper(coins, i, amount - coins[i], dp);
                    // int pick = (take == Integer.MAX_VALUE) ? take : take + 1; // no need if we have long type
                    long take = 1 + dp[i][j-coins[i]];
                    dp[i][j] = Math.min(skip, take);
                }
            }
        }
        int ans = (int)dp[coins.length-1][amount];
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    // memoization
//    private static int coinChange(int[] coins, int amount) {
//        int[][] dp = new int[coins.length][amount+1];
//        int ans = helper(coins, 0, amount, dp);
//        return (ans == Integer.MAX_VALUE) ? -1 : ans;
//    }
//    private static int helper(int[] coins, int i, int amount, int[][] dp) {
//        if (i == coins.length) {
//            if (amount == 0) return 0; // valid ans
//            else return Integer.MAX_VALUE; // invalid ans
//        }
//        if (dp[i][amount] != 0) return dp[i][amount];
//
//        int skip = helper(coins, i + 1, amount, dp);
//        if (coins[i] > amount) return dp[i][amount] = skip;
//
//        int take = helper(coins, i, amount - coins[i], dp);
//        int pick = (take == Integer.MAX_VALUE) ? take : take + 1;
//        return dp[i][amount] = Math.min(pick, skip);
//    }
}