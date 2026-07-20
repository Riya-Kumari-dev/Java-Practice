package dsa.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class MinCostClimbingStairs {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of stairs : ");
        int n = sc.nextInt();
        int[] cost = new int[n];
        System.out.print("Enter the cost of each stairs (total " + n + " stairs ) : ");
        for(int i=0; i<n; i++){
            cost[i] = sc.nextInt();
        }
        System.out.println("Minimum cost to reach the top of the floor is "+minCostClimbingStairs(cost));
    }

    // space optimized
    // TC = O(n) , AS = O(1)
    private static int minCostClimbingStairs(int[] cost) {
        if(cost.length<=1) return cost[0];
        int[] dp = new int[3];
        dp[0] = cost[0];
        dp[1] = cost[1];
        if(cost.length == 2) return Math.min(dp[0], dp[1]);
        for(int i=2; i<cost.length; i++){
            dp[2] = cost[i] + Math.min(dp[1], dp[0]);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return Math.min(dp[2], dp[0]);
    }

    // tabulation
    // TC = O(n) , AS = O(n)
//    private static int minCostClimbingStairs(int[] cost) {
//        int[] dp = new int[cost.length];
//        dp[0] = cost[0];
//        dp[1] = cost[1];
//        for(int i=2; i<cost.length; i++){
//            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
//        }
//        return Math.min(dp[cost.length-1], dp[cost.length-2]);
//    }

    // memoization
    // TC = O(n) , AS = O(n)
//    private static int minCostClimbingStairs(int[] cost) {
//        int[] dp = new int[cost.length];
//        Arrays.fill(dp, -1);
//        return Math.min(minCost(0, cost,dp), minCost(1, cost, dp));
//    }
//    private static int minCost(int i, int[] cost, int[] dp){
//        if(i>= cost.length) return 0; // no paisa required for final stair
//        if(dp[i] != -1) return dp[i];
//        return dp[i] = cost[i] + Math.min(minCost(i+1, cost, dp), minCost(i+2, cost, dp)); // one jump or two jump
//    }
}