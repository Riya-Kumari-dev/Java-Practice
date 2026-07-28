package dsa.dynamicprogramming;

import java.util.Scanner;

import static dsa.dynamicprogramming.LongestPalindromicSubsequence.longestPalindromeSubseq;

public class MinimumInsertionToMakeStringPalindrome {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String s = sc.nextLine();
        System.out.println("Minimum insertions needed to make "+s+" palindrome is "+minInsertions(s));
    }
    private static int minInsertions(String s) {
        // we have to insert the counterpart of each letter which are not the part of palindromic subsequence
        // that means total length - lps
        return s.length()-longestPalindromeSubseq(s);
    }
}