package dsa.dynamicprogramming;

import java.util.ArrayList;
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
    private static int lengthOfLongestSubsequence(List<Integer> arr, int target) {
        int n = arr.size();
        int[][] dp = new int[n][target+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) dp[i][j] = -2;
        }
        return helper(arr, target, 0, dp);
    }

    private static int helper(List<Integer> arr, int target, int idx, int[][] dp) {
        if (idx >= arr.size()) {
            if(target == 0) return 0;
            return -1;
        }
        if (dp[idx][target] != -2) return dp[idx][target];
        int skip = helper(arr, target, idx + 1, dp);
        if (target - arr.get(idx) < 0) return dp[idx][target] = skip;
        int pick = -1;
        int res = helper(arr, target - arr.get(idx), idx + 1, dp);
        if(res != -1) pick = 1+ res;
        return dp[idx][target] = Math.max(pick, skip);
    }
}