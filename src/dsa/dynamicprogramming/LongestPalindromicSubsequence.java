package dsa.dynamicprogramming;

import java.util.Scanner;

public class LongestPalindromicSubsequence {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String s = sc.nextLine();
        System.out.println("Longest palindromic subsequence is "+longestPalindromeSubseq(s));
    }
    public static int longestPalindromeSubseq(String s) {
        // code here
        StringBuilder s1 = new StringBuilder(s);
        StringBuilder s2 = new StringBuilder(s);
        s2.reverse();
        return longestCommonSubseq(s1,s2);
    }
    // lps(s) = lcs(s, reverse(s));
    public static int longestCommonSubseq(StringBuilder s1, StringBuilder s2) {
        // code here
        int[][] dp = new int[s1.length()][s2.length()];
        for(int i=0; i< dp.length; i++){
            for(int j=0; j<dp[0].length; j++) dp[i][j] = -1;
        }
        return helper(s1.length()-1, s1, s2.length()-1, s2 , dp);
    }
    public static int helper(int i, StringBuilder s1, int j, StringBuilder s2, int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        char ch = s1.charAt(i); char dh = s2.charAt(j);
        if(ch != dh) {
            return dp[i][j] = Math.max(helper(i-1, s1, j, s2, dp), helper(i, s1, j-1, s2, dp));
        }
        else return dp[i][j] = 1 + helper(i-1, s1, j-1, s2, dp);
    }
}