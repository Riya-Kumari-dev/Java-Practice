package dsa.dynamicprogramming;

import java.util.Scanner;

import static dsa.dynamicprogramming.LongestCommonSubsequence.longestCommonSubsequence;

public class LongestPalindromicSubsequence {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String s = sc.nextLine();
        System.out.println("Longest palindromic subsequence is "+longestPalindromeSubseq(s));
    }
    public static int longestPalindromeSubseq(String s) {
        StringBuilder s2 = new StringBuilder(s);
        s2.reverse();
        return longestCommonSubsequence(s,s2.toString());
    }
    // lps(s) = lcs(s, reverse(s));
}