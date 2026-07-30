package dsa.dynamicprogramming;

import java.util.Scanner;

public class LongestPalindromicSubstring {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String s = sc.nextLine();
        System.out.println("Longest palindromic substrings in "+s+" is "+longestPalindrome(s));
    }

    private static String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int maxLength = 0;
        int count = 0;
        for(int k=0; k<n;k++) { // how many times the loop will run
            // we have to fill diagonally
            int i=0; int j=k;
            while(j<n){
                if(i==j) dp[i][j] = 1; // same character (single character)=> obviously palindrome
                else if(j==i+1){ // two characters
                    if(s.charAt(i) == s.charAt(j)) dp[i][j] = 2;
                }
                else {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (dp[i + 1][j - 1] != 0)
                            dp[i][j] = 2 + dp[i+1][j-1]; // beech wale palindrome hai and the corners characters are also same then it is a palindrome
                        else dp[i][j] = 0;
                    } else dp[i][j] = 0; // characters differ then not a palindrome
                }
                maxLength = Math.max(dp[i][j], maxLength);
                i++;
                j++;
            }

        }

        // find the substring
        int x = 0; int y = 0;
        boolean flag = false; // only to break the outer loop
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(dp[i][j] == maxLength){
                    x = i;
                    y = j;
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        return s.substring(x, y+1);
    }
}