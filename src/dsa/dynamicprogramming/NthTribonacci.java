package dsa.dynamicprogramming;

import java.util.Scanner;

public class NthTribonacci {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the term : ");
        int n = sc.nextInt();
        System.out.println(n+"th tribonacci number is "+tribonacci(n));
    }
    // space optimized
    private static int tribonacci(int n) {
        if(n <= 1) return n;
        int[] dp = new int[4];
        dp[0] = 0; dp[1] = 1; dp[2] = 1;
        for(int i=3; i<=n; i++){
            dp[3] = dp[0] + dp[1] + dp[2];
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = dp[3];
        }
        return dp[3];
    }

//    private static int tribonacci(int n) {
//        if(n <= 1) return n;
//        int[] dp = new int[n+1];
//        dp[0] = 0; dp[1] = 1; dp[2] = 1;
//        for(int i=3; i<=n; i++){
//            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
//        }
//        return dp[n];
//    }
}