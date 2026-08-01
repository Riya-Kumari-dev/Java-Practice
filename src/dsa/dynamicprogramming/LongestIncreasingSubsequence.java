package dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the given array : ");
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        System.out.println("Length of the longest increasing subsequence in "+ Arrays.toString(arr)+" is "+lengthOfLIS(arr));
    }
    // binary search
    private static int lengthOfLIS(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int ele : arr){
            if(ans.isEmpty() || ans.getLast() < ele) ans.add(ele);
            else replace(ans, ele); // replace with its lower bound
        }
        return ans.size();
    }
    private static int replace(ArrayList<Integer> ans, int ele){
        int lo = 0; int hi = ans.size()-1; int lb = -1;
        while(lo<=hi){
            int mid = lo + (hi - lo)/2;
            if(ans.get(mid) >= ele){
                lb = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return ans.set(lb, ele);
    }

    // tabulation
    // TC = O(n^2), AS = O(n)
//    private static int lengthOfLIS(int[] arr){
//        int n = arr.length;
//        // dp[i] will store the length of LIS upto that point including that number
//        int[] dp = new int[n];
//        Arrays.fill(dp, 1);
//        int maxLength = 1;
//        for(int i=1; i<n; i++){
//            int length = 0;
//            for(int j=i-1; j>=0; j--){
//                if(arr[i] > arr[j]) {
//                    length = Math.max(Length, dp[j]);
//                }
//            }
//            dp[i] += length;
//            maxLength = Math.max(maxLength, dp[i]);
//        }
//        return maxLength;
//    }

    // memoization
    // TC = O(n^2), AS = O(n^2)
//     private static int lengthOfLIS(int[] arr){
//        int n = arr.length;
//        // idx -> 0 to n-1 and prevIdx -> -1 to n-1
//        int[][] dp = new int[n][n+1];
//        for(int i=0; i<n; i++){
//            for(int j=0; j<=n; j++){
//                dp[i][j] = -1;
//            }
//        }
//        return helper(0, -1, arr, dp);
//    }
    //private static int helper(int idx, int prevIdx, int[] arr, int[][] dp){
//        if(idx == arr.length) return 0;
//        if(dp[idx][prevIdx+1] != -1) return dp[idx][prevIdx+1];
//        int skip = helper(idx+1, prevIdx, arr, dp);
//        if(prevIdx != -1 && arr[idx] <= arr[prevIdx]) return dp[idx][prevIdx+1] = skip;
//        int pick = 1 + helper(idx+1, idx, arr, dp);
//        return dp[idx][prevIdx+1] = Math.max(pick, skip);
//    }

    // recursion
//    private static int lengthOfLIS(int[] arr){
//        return helper(0, -1, arr);
//    }
//    private static int helper(int idx, int prevIdx, int[] arr){
//        if(idx == arr.length) return 0;
//        int skip = helper(idx+1, prevIdx, arr);
//        if(prevIdx != -1 && arr[idx] <= arr[prevIdx]) return skip;
//        int pick = 1 + helper(idx+1, idx, arr);
//        return Math.max(pick, skip);
//    }
}
