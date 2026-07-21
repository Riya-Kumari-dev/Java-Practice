package dsa.dynamicprogramming;

import java.util.Scanner;

public class PerfectSquares {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = sc.nextInt();
        System.out.println("Least number of perfect square numbers that sum to n is "+numSquares(n));
    }
    private static boolean isPerfectSquare(int n){
        int m = (int)Math.sqrt(n);
        return m * m == n;
    }
    // tabulation
    // TC = O(n*root(n)), AS = O(n)
    private static int numSquares(int n){
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++){
            if(isPerfectSquare(i)) dp[i] = 1;
            else {
                int min = n;
                for(int j=1; j<=(int)Math.sqrt(i); j++){
                    int count = dp[j*j] + dp[i-j*j];
                    min = Math.min(count, min);
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }

    // TC = O(n^2) still accepted => tabulation is better than recursion + memoization
//    private static int numSquares(int n){
//        int[] dp = new int[n+1];
//        for(int i=1; i<=n; i++){
//            if(isPerfectSquare(i)) dp[i] = 1;
//            else {
//                int min = n;
//                for(int j=1; j<=i/2; j++){
//                    int count = dp[j] + dp[i-j];
//                    min = Math.min(count, min);
//                }
//                dp[i] = min;
//            }
//        }
//        return dp[n];
//    }

    // memoization
//    private static int numSquares(int n) {
//        int[] dp = new int[n+1];
//        Arrays.fill(dp, -1);
//        return minSquares(n, dp);
//    }

//    // accepted
//    //TC = O(n*root(n)) , AS = O(n)
//    private static int minSquares(int n, int[] dp) {
//        if(isPerfectSquare(n)) return 1;
//        if(dp[n] != -1) return dp[n];
//        int min = n; // because maximum is when taking all one and that one will be n times for sure
//        for(int i=1; i<=(int)Math.sqrt(n); i++){
//            int count = minSquares(i*i, dp) + minSquares(n-i*i, dp); // i*i is definitely perfect square
//            min = Math.min(min, count);
//        }
//        return dp[n] = min;
//    }

    //  TLE , TC = O(n^2), AS = O(n)
//    private static int minSquares(int n, int[] dp) {
//        if(isPerfectSquare(n)) return 1;
//        if(dp[n] != -1) return dp[n];
//        int min = n; // because maximum is when taking all one and that one will be n times for sure
//        for(int i=1; i<=n/2; i++){
//            int count = minSquares(i, dp) + minSquares(n-i, dp);
//            min = Math.min(min, count);
//        }
//        return dp[n] = min;
//    }

    // time limit exceeded
    // TC = O(n^n)
//    private static int numSquares(int n) {
//        if(isPerfectSquare(n)) return 1;
//        int min = n; // because maximum is when taking all one and that one will be n times for sure
//        for(int i=1; i<=n/2; i++){
//            int count = numSquares(i) + numSquares(n-i);
//            min = Math.min(min, count);
//        }
//        return min;
//    }
}