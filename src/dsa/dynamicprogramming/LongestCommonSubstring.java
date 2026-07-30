package dsa.dynamicprogramming;

import java.util.Scanner;

public class LongestCommonSubstring {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string : ");
        String s1 = sc.nextLine();
        System.out.print("Enter second string : ");
        String s2 = sc.nextLine();
        System.out.println("Longest common substring in "+s1+" and "+s2+" is "+longCommSubstr(s1, s2));
    }
    // tabulation
    private static int longCommSubstr(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int maxLength = 0;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int x = (i>=1 && j>=1) ? dp[i-1][j-1] : 0;
                if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = 1 + x;
                else dp[i][j] = 0;
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength;
    }

    // recursion
//    static int maxLength;
//    private static int longCommSubstr(String s1, String s2) {
//        // code here
//        int m = s1.length(); int n = s2.length();
//        maxLength = 0;
//        helper(m-1, n-1, new StringBuilder(s1), new StringBuilder(s2));
//        return maxLength;
//    }
//    private static int helper(int i, int j, StringBuilder s1, StringBuilder s2){
//        if(i<0 || j<0) return 0;
//        if(s1.charAt(i) == s2.charAt(j)){
//            int len = 1 + helper(i-1, j-1, s1, s2);
//            maxLength = Math.max(maxLength, len);
//            return len;
//        }
//        else{
//            int len = Math.max(helper(i-1, j, s1, s2), helper(i ,j-1, s1, s2));
//            maxLength = Math.max(maxLength, len);
//            return 0;
//        }
//    }
}