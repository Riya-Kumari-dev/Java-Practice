package dsa.dynamicprogramming;

import java.util.Scanner;

public class NthFibonacci {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the term : ");
        int n = sc.nextInt();
        System.out.println(n+"th fibonacci number is "+fibo(n));
    }
    // space optimized
    private static int fibo(int n) {
        // code here
        if(n<=1) return n;
        int[] dp = new int[3];
        dp[1] = 1;
        for(int i=1; i<n; i++){ // n-1 times
            dp[2] = dp[1] + dp[0];
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }

    // Tabulation / Bottom up / iterative dp TC = O(n) , SC = O(n)
//    private static int fibo(int n){
//        if(n<=1) return n;
//        int[] dp = new int[n];
//        dp[1] = 1;
//        for(int i=2; i<=n; i++){
//            dp[i] = dp[i-1]+ dp[i-2];
//        }
//        return dp[n];
//    }

    // Memoization (Top down dp / recursive dp)  TC = O(n) , SC = O(n)
//    private static int fibo(int n){
//        if(n<=1) return n;
//        if(dp[n] != 0) return dp[n];
//        int ans = fibo(n-1) + fibo(n-2);
//        dp[n] = ans;
//        return ans;
//    }

    // recursion => TC = O(2^n) , SC =  O(n)
//    private static int fibo(int n){
//        if(n == 0 || n==1) return n;
//        return fibo(n-1) + fibo(n-2);
//    }
}