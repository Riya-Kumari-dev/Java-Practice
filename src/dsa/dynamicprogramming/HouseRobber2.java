package dsa.dynamicprogramming;

import java.util.Scanner;

public class HouseRobber2 {
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

    // . All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
    // Meanwhile, adjacent houses have a security system connected, and
    // it will automatically contact the police if two adjacent houses were broken into on the same night.

    // tabulation
    private static int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(robbery(0, nums.length-2, nums), robbery(1, nums.length-1,nums));
    }
    private static int robbery(int start, int end, int[] arr) {
        int n = end - start + 1;
        int[] dp = new int[n];
        dp[0] = arr[start];
        if (n > 1) dp[1] = Math.max(dp[0], arr[start + 1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], (arr[start + i] + dp[i - 2]));
        }
        return dp[n - 1];
    }
}
