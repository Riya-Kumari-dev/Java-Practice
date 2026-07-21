package dsa.dynamicprogramming;

import java.util.Scanner;

public class UniquePaths {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows of the matrix : ");
        int m = sc.nextInt();
        System.out.print("Enter the number of columns of the matrix : ");
        int n = sc.nextInt();
        System.out.println(uniquePaths(m,n));
    }
    // space optimized
    private static int uniquePaths(int m, int n) {
        int[][] dp = new int[2][n];
        for(int j=0; j<n; j++){
            dp[0][j] = 1;
        }
        dp[1][0] = 1;
        for(int i=0; i<m/2; i++){
            // 2nd row
            for(int j=1; j<n; j++){
                dp[1][j] = dp[0][j] + dp[1][j-1];
            }
            // first row , first me hi doosra kaam kar diya
            for(int j=1; j<n; j++){
                dp[0][j] = dp[1][j] + dp[0][j-1];
            }
        }
        if(m%2 == 0) return dp[1][n-1];
        else return dp[0][n-1];
    }

    //tabulation
    // TC = O(m*n) , AS = O(m*n)
//    private static int uniquePaths(int m, int n){
//        // dp[i][j] is storing no. of paths from start to i,j
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(i==0 || j==0) dp[i][j] = 1;
//                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
//            }
//        }
//        return dp[m-1][n-1];
//    }

    // memoization
    // TC = O(m*n) , AS = O(m*n)
//    private static int uniquePaths(int m, int n){
//        dp = new int[m+1][n+1]; // 0 to m and 0 to n
//        return paths(m,n);
//    }
//    private static int paths(int m, int n, int[] dp){ // 1 to m and 1 to n
//        if(m==1 || n==1) return 1;
//        if(dp[m][n] != 0) return dp[m][n];
//        return dp[m][n] = paths(m, n-1, dp) + paths(m-1, n, dp);
//    }

    // recursion => show runtime error
    // TC = O(2^(m*n)) , AS = O(m*n)
//    private static int uniquePaths(int m, int n) {
//        if(m==1 || n==1) return 1;
//        return uniquePaths(m,n-1) + uniquePaths(m-1, n);
//    }
}
