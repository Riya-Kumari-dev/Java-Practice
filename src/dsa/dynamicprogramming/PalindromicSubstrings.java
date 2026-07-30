package dsa.dynamicprogramming;

import java.util.Scanner;

public class PalindromicSubstrings {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String s = sc.nextLine();
        System.out.println("Total number of palindromic substrings in "+s+" is "+countSubstrings(s));
    }

    private static int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int count = 0;
        for(int k=0; k<n;k++) { // how many times the loop will run
            // we have to fill diagonally
            int i=0; int j=k;
            while(j<n){
                if(i==j) dp[i][j] = 1; // same character (single character)=> obviously palindrome
                else if(j==i+1){ // two characters
                    if(s.charAt(i) == s.charAt(j)) dp[i][j] = 1;
                }
                else {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (dp[i + 1][j - 1] == 1)
                            dp[i][j] = 1; // beech wale palindrome hai and the corners characters are also same then it is a palindrome
                        else dp[i][j] = 0;
                    } else dp[i][j] = 0; // characters differ then not a palindrome
                }
                if(dp[i][j] != 0) count++;
                i++;
                j++;
            }

        }
        return count;
    }
}