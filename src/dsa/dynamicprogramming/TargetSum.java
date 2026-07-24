package dsa.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class TargetSum {
    // You want to build an expression out of arr by adding one of the symbols '+' and '-' before each integer in arr and
    // then concatenate all the integers
    //For example, if arr = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
    //Return the number of different expressions that you can build, which evaluates to target.

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter "+n+" elements for the array : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter target : ");
        int target = sc.nextInt();
        System.out.println("Total number of different expressions that can build from "+ Arrays.toString(arr)+" which evaluates to "+target+" is "+findTargetSumWays(arr, target));
    }
    private static int findTargetSumWays(int[] arr, int target) {
        // i ->  0 to n-1 and target -> -absSum to +absSum
        // => but index can't be negative thus adding both sides absSum
        // target -> 0 to 2*absSum
        int absSum = 0;
        for(int ele : arr) absSum += Math.abs(ele);

        int[][] dp = new int[arr.length][2*absSum+1];
        return helper(0, arr,absSum, 0, target, dp);

    }
    private static int helper(int i, int[] arr,int absSum, int sum, int target, int[][] dp){
        if(i == arr.length) {
            if(target == sum) return 1; // 1 valid way
            else return 0;
        }
        if(dp[i][sum + absSum] != 0) return dp[i][sum+absSum]; // so that index not negative
        int plus = helper(i+1, arr, absSum,sum-arr[i], target, dp);
        int minus = helper(i+1, arr, absSum, sum+arr[i], target, dp);
        return dp[i][sum+absSum] = plus + minus;
    }

//    private static int findTargetSumWays(int[] arr, int target) {
//        return helper(0, arr, target);
//    }
//    private static int helper(int i, int[] arr, int target){
//        if(i == arr.length) {
//            if(target == 0) return 1; // 1 valid way
//            else return 0;
//        }
//        int plus = helper(i+1, arr, target - arr[i]);
//        int minus = helper(i+1, arr, target + arr[i]);
//        return plus + minus;
//    }
}