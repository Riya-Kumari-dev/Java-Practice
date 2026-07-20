package dsa.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class HouseRobber {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of houses in the street : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.print("Enter the amounts of money in each houses (total " + n + " houses ) : ");
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Maximum amount of money you can rob tonight is "+rob(nums));
    }

    // . Each house has a certain amount of money stashed,
    // the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
    // it will automatically contact the police
    // if two adjacent houses were broken into on the same night.

    // tabulation
    private static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        if(n>1) dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            // dp[i] stores the maximum amount of money that the robber can rob from 0 to ith house
            dp[i] = Math.max((nums[i] + dp[i - 2]), dp[i - 1]); // max of pick and skip
        }
        return dp[n-1];
    }

    // memoization
//    private static int rob(int[] nums) {
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, -1);
//        return robbery(0, nums, dp);
//    }
//    private static int robbery(int idx, int[] nums, int[] dp){
//        if(idx >= nums.length) return 0; // no paisa as no house
//        if(dp[idx] != -1) return dp[idx];
//        int pick = nums[idx] + robbery(idx+2, nums, dp);
//        int skip = robbery(idx+1, nums, dp);
//        return dp[idx] = Math.max(pick, skip);
//    }
}