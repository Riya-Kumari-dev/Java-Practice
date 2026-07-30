package dsa.dynamicprogramming;

import java.util.Scanner;

public class PrintLongestCommonSubsequence {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string : ");
        String s1 = sc.nextLine();
        System.out.print("Enter second string : ");
        String s2 = sc.nextLine();
        System.out.println("Longest common subsequence in "+s1+" and "+s2+" is "+lcs(s1,s2));
    }
    public static String lcs(String s1, String s2) {
        int m = s1.length(); int n = s2.length();
        // fill the dp
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++) {
                if(s1.charAt(i-1) != s2.charAt(j-1)) dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                else dp[i][j] = 1 + dp[i-1][j-1];
            }
        }
        // printing lcs
        StringBuilder ans = new StringBuilder();
        int i=m; int j = n;
        while(i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                ans.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(dp[i-1][j] >= dp[i][j-1]) {
                    i--;
                }
                else j--;
            }
        }
        ans.reverse();
        return ans.toString();
    }
}