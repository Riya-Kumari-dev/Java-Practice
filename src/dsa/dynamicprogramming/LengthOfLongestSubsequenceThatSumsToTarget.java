package dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LengthOfLongestSubsequenceThatSumsToTarget {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the list : ");
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr.add(x);
        }
        System.out.print("Enter the target : ");
        int target = sc.nextInt();
        int ans = lengthOfLongestSubsequence(arr, target);
        if(ans == -1) System.out.println("There is not any subsequence in " + arr + " that sums to " + target);
        else System.out.println("Length of longest subsequence in "+arr+" that sum to "+target+" is "+ans);
    }

    // space optimized
    private static int lengthOfLongestSubsequence(List<Integer> arr, int target) {
        int n = arr.size();
        int[][] dp = new int[2][target + 1];

        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                int skip = dp[0][j];
                int pick = -1;
                if (j >= arr.get(i) && dp[0][j - arr.get(i)] != -1) {
                    pick = dp[0][j - arr.get(i)] + 1;
                }
                dp[1][j] = Math.max(skip, pick);
            }

            for(int j=0; j<= target; j++) dp[0][j] = dp[1][j];
        }

        return dp[0][target];
    }
    // tabulation
//    private static int lengthOfLongestSubsequence(List<Integer> arr, int target) {
//        int n = arr.size();
//        int[][] dp = new int[n][target + 1];
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                int skip = (i > 0) ? dp[i - 1][j] : ((j == 0) ? 0 : -1);
//                int pick = -1;
//                if (i > 0) {
//                    if (j >= arr.get(i) && dp[i - 1][j - arr.get(i)] != -1) {
//                        pick = dp[i - 1][j - arr.get(i)] + 1;
//                    }
//                } else {
//                    // Base case for first element
//                    if (j == arr.get(0))
//                        pick = 1;
//                }
//                dp[i][j] = Math.max(skip, pick);
//            }
//        }
//
//        return dp[n - 1][target];
//    }

    // memoization
//    private static int lengthOfLongestSubsequence(List<Integer> arr, int target) {
//        int n = arr.size();
//        int[][] dp = new int[n][target+1];
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) dp[i][j] = -2;
//        }
//        return helper(arr, target, 0, dp);
//    }
//
//    private static int helper(List<Integer> arr, int target, int idx, int[][] dp) {
//        if (idx >= arr.size()) {
//            if(target == 0) return 0;
//            return -1;
//        }
//        if (dp[idx][target] != -2) return dp[idx][target];
//        int skip = helper(arr, target, idx + 1, dp);
//        if (target - arr.get(idx) < 0) return dp[idx][target] = skip;
//        int pick = -1;
//        int res = helper(arr, target - arr.get(idx), idx + 1, dp);
//        if(res != -1) pick = 1+ res;
//        return dp[idx][target] = Math.max(pick, skip);
//    }
}