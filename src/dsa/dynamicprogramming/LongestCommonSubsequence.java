package dsa.dynamicprogramming;

import java.util.Scanner;

public class LongestCommonSubsequence {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string : ");
        String s1 = sc.nextLine();
        System.out.print("Enter second string : ");
        String s2 = sc.nextLine();
        System.out.println("Longest common subsequence in "+s1+" and "+s2+" is "+longestCommonSubsequence(s1,s2));
    }

    // space optimized , TC = O(m*n), AS = (n)
    public static int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[2][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) != s2.charAt(j - 1)) dp[1][j] = Math.max(dp[0][j], dp[1][j - 1]);
                else dp[1][j] = 1 + dp[0][j - 1];
            }
            // copy the 1st row to 0th row for next time
            for (int j = 0; j <= n; j++) dp[0][j] = dp[1][j];
        }
        return dp[1][n];
    }
    // tabulation
//    private static int lcs(String s1, String s2) {
//        int m = s1.length(); int n = s2.length();
//        int[][] dp = new int[m+1][n+1];
//        for(int i=1; i<=m; i++){
//            for(int j=1; j<=n; j++) {
//                if(s1.charAt(i-1) != s2.charAt(j-1)) dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
//                else dp[i][j] = 1 + dp[i-1][j-1];
//            }
//        }
//        return dp[m][n];
//    }
    // tabulation
//    private static int lcs(String s1, String s2) {
//        int[][] dp = new int[s1.length()][s2.length()];
//        for(int i=0; i< dp.length; i++){
//            for(int j=0; j<dp[0].length; j++) {
//                int x = (i>=1) ? dp[i-1][j] : 0;
//                int y = (j>=1) ? dp[i][j-1] : 0;
//                int z = (x>=1 && y>=1) ? dp[i-1][j-1] : 0;
//                if(s1.charAt(i) != s2.charAt(j)) {
//                    dp[i][j] = Math.max(x, y);
//                }
//                else  dp[i][j] = 1 + z;
//            }
//        }
//        return dp[s1.length()-1][s2.length()-1];
//    }

    // memoization
//    private static int lcs(String s1, String s2) {
//        int[][] dp = new int[s1.length()][s2.length()];
//        for(int i=0; i< dp.length; i++){
//            for(int j=0; j<dp[0].length; j++) dp[i][j] = -1;
//        }
//        return helper(s1.length()-1, new StringBuilder(s1), s2.length()-1, new StringBuilder(s2) , dp);
//    }
//    private static int helper(int i, StringBuilder s1, int j, StringBuilder s2, int[][] dp){
//        if(i<0 || j<0) return 0;
//        if(dp[i][j] != -1) return dp[i][j];
//        char ch = s1.charAt(i); char dh = s2.charAt(j);
//        if(ch != dh) {
//            return dp[i][j] = Math.max(helper(i-1, s1, j, s2, dp), helper(i, s1, j-1, s2, dp));
//        }
//        else return dp[i][j] = 1 + helper(i-1, s1, j-1, s2, dp);
//    }

    // recursion
//    static int lcs(String s1, String s2) {
//        return helper(s1.length()-1, s1, s2.length()-1, s2 );
//    }
//    static int helper(int i, String s1, int j, String s2){
//        if(i<0 || j<0) return 0;
//        char ch = s1.charAt(i); char dh = s2.charAt(j);
//        if(ch != dh) {
//            return Math.max(helper(i-1, s1, j, s2), helper(i, s1, j-1, s2));
//        }
//        else return 1 + helper(i-1, s1, j-1, s2);
//    }
}