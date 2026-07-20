package dsa.dynamicprogramming;

import java.util.Scanner;

public class FriendsPairingProblem {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of friends : ");
        int n = sc.nextInt();
        System.out.print("Total number of ways in which friends can remain single or can be paired up is "+countFriendsPairings(n));
    }

    // Given n friends, each one can remain single or can be paired up with some other friend.
    // Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up

    // tabulation
    private static long countFriendsPairings(int n) {
        long[] dp = new long[n+1];
        dp[1] = 1;
        if(n>1) dp[2] = 2;
        for(int i=3;i<=n; i++){
            dp[i] = dp[i-1] + (i-1)*dp[i-2];
        }
        return dp[n];
    }

    // memoization
//    private static long countFriendsPairings(int n) {
//        long[] dp = new long[n+1];
//        return friends(n, dp);
//    }
//    private static long friends(int n, long[] dp){
//        if(n<=2) return n;
//        if(dp[n] != 0) return dp[n];
//        return dp[n] = friends(n-1, dp) + (n-1)* friends(n-2, dp);
//    }

    // recursion
//    private static long countFriendsPairings(int n) {
//        if(n<=2) return n;
//        // jab a single ho + jab a pair hoga (baaki n-1 se aur ek ke sath pair then rest n-2 left )
//        return countFriendsPairings(n-1) + (n-1)*countFriendsPairings(n-2);
//    }
}
