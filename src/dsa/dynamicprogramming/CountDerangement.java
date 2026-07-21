package dsa.dynamicprogramming;
import java.util.Scanner;

public class CountDerangement {
    //  A Derangement is a permutation of n elements, such that no element appears in its original position,
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of postcards : ");
        int n = sc.nextInt();
        System.out.println("Total number of derangement from 1 to "+n+" is "+derangeCount(n));
    }

    // tabulation
    private static int derangeCount(int n) {
        int[] dp = new int[n+1];
        dp[1] = 0;
        if(n> 1) dp[2] = 1;
        for(int i=3; i<=n; i++){
            dp[i] = (i-1)*(dp[i-1] + dp[i-2]);
        }
        return dp[n];
    }

    // memoization
//    private static int derangeCount(int n) {
//        int[] dp = new int[n+1];
//        return count(n, dp);
//    }
//
//    private static int count(int n, int[] dp) {
//        if(n<=2) return n-1;
//        if(dp[n] != 0) return dp[n];
//        return dp[n] = (n-1)*(count(n-1, dp) + count(n-2, dp));
//    }

    // recursion
//    private static int derangeCount(int n) {
//        if(n<=2) return n-1;
//        return (n-1)*(derangeCount(n-1) + derangeCount(n-2));
//    }
}