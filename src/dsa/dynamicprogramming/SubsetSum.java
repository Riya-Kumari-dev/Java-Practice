package dsa.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class SubsetSum {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the target : ");
        int target = sc.nextInt();
        if (isSubsetSum(arr, target))
            System.out.println("Yes, " + Arrays.toString(arr) + " has a subset whose sum equals to " + target);
        else System.out.println("No, " + Arrays.toString(arr) + " has not any subset whose sum equals to " + target);
    }

    // memoization
    // TC = O(n*target) , AS = O(n*target)
    public static boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;
        // idx -> 0 to n-1 and target -> target to 0
        int[][] dp = new int[n][target+1]; // integer type(no boolean type) because we want something different to understand whether ans is marked or not
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) dp[i][j] = -1;
        }
        return helper(arr, target, 0, dp);
    }

    public static boolean helper(int[] arr, int target, int idx, int[][] dp) {
        if (idx >= arr.length) {
            return target == 0;
        }
        if (dp[idx][target] != -1) return dp[idx][target] == 1;
        boolean ans;
        boolean skip = helper(arr, target, idx + 1, dp);
        if (target - arr[idx] < 0) ans = skip; // only for +ve numbers
        else {
            boolean pick = helper(arr, target - arr[idx], idx + 1, dp);
            ans = pick || skip;
        }
        dp[idx][target] = (ans) ? 1 : 0;
        return ans;
    }


    // recursion
    // TC = O(2^n) AS = O(n*target)
//    private static boolean isSubsetSum(int[] arr, int target) {
//        return helper(arr, target, 0);
//    }
//
//    private static boolean helper(int[] arr, int target, int idx) {
//        if(idx >= arr.length) {
//            return target == 0;
//        }
//        boolean skip = helper(arr, target, idx+1);
//        if(target-arr[idx] < 0) return skip; // only for +ve numbers
//        boolean pick = helper(arr, target-arr[idx], idx+1);
//        return pick || skip;
//    }
}