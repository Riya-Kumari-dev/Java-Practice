package dsa.dynamicprogramming;

import java.util.Scanner;

public class EditDistance {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first word : ");
        String word1 = sc.nextLine();
        System.out.print("Enter second word : ");
        String word2 = sc.nextLine();
        System.out.println("Minimum number of operations required to convert "+word1+" into "+word2+" is "+minDistance(word1, word2));
    }
    // tabulation
    private static int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if(m==0) return n;
        if(n==0) return m;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int p = (i>0 && j>0) ? dp[i-1][j-1] : (i==0 ? j : i);
                int q = (i>0) ? dp[i-1][j] : j;
                int r =(j>0) ?  dp[i][j-1] : i;
                if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = p;
                else{
                    int replace = 1 + p;
                    int remove = 1 + q;
                    int insert = 1 + r;
                    dp[i][j] = Math.min(replace, Math.min(remove, insert));
                }
            }
        }
        return dp[m-1][n-1];
    }
    // memoization
//    private static int minDistance(String s1, String s2) {
//        int m = s1.length();
//        int n = s2.length();
//        int[][] dp = new int[m][n];
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++) dp[i][j] = -1;
//        }
//        return minSteps(m - 1, n - 1, new StringBuilder(s1), new StringBuilder(s2), dp);
//    }
//    private static int minSteps(int i, int j, StringBuilder s1, StringBuilder s2, int[][] dp){
//        if(i<0) return j+1; // inserting remaining characters of s2
//        if(j<0) return i+1;  // removing remaining characters of s1
//        if(dp[i][j] != -1) return dp[i][j];
//        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = minSteps(i-1, j-1, s1, s2, dp);
//        int replace = 1 + minSteps(i-1, j-1, s1,s2, dp);
//        int remove = 1 + minSteps(i-1, j, s1, s2, dp);
//        int insert = 1 + minSteps(i, j-1, s1, s2, dp);
//        return dp[i][j] = Math.min(replace, Math.min(remove, insert));
//    }
    // recursion
//    public int minDistance(int i, int j, StringBuilder s1, StringBuilder s2){
//        if(i<0) return j+1; // inserting remaining characters of s2
//        if(j<0) return i+1;  // removing remaining characters of s1
//        if(s1.charAt(i) == s2.charAt(j)) return minDistance(i-1, j-1, s1, s2);
//        int replace = 1 + minDistance(i-1, j-1, s1,s2);
//        int remove = 1 + minDistance(i-1, j, s1, s2);
//        int insert = 1 + minDistance(i, j-1, s1, s2);
//        return Math.min(replace, Math.min(remove, insert));
//    }
}
