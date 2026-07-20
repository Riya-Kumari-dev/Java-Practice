package dsa.dynamicprogramming;

import java.util.Scanner;

public class WaysToReachNthStair {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of stairs : ");
        int n = sc.nextInt();
        System.out.println("Total number of ways to reach "+n+"th stair is "+countWays(n));
    }
    // one jump or two jump
    // Tabulation
    private static int countWays(int n) {
        if(n<=2) return n;
        int[] dp = new int[n];
        dp[0] = 1; dp[1] = 2;
        for(int i=2; i<n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

    // memoization
//    private static int countWays(int n) {
//        int[] dp = new int[n+1];
//        return ways(n, dp);
//    }
//    int ways(int n, int[] dp){
//        if(n == 1 || n==2) return n;
//        if(dp[n] != 0) return dp[n];
//        return dp[n] = ways(n-1, dp) + ways(n-2, dp);
//    }

    // recursion
//    int countWays(int n) {
//        if(n<=2) return n;
//        return countWays(n-1)+countWays(n-2);
//    }
}