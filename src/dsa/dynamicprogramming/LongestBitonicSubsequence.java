package dsa.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class LongestBitonicSubsequence {
    //  A subsequence of array is called Bitonic if it is first strictly increasing, then strictly decreasing.
    //  Return the maximum length of bitonic subsequence.
    //Note : A strictly increasing or a strictly decreasing sequence should not be considered as a bitonic sequence
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the given array : ");
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        System.out.println("Length of the longest bitonic subsequence in "+ Arrays.toString(arr)+" is "+longestBitonicSubsequence(arr));
    }
    private static int longestBitonicSubsequence(int[] arr) {
        int n = arr.length;
        int[] dp1 = new int[n]; int[] dp2 = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        // lis => Longest increasing subsequence
        for(int i=1; i<n; i++){
            int length = 0;
            for(int j=i-1; j>=0; j--){
                if(arr[i] > arr[j]) {
                    length = Math.max(length, dp1[j]);
                }
            }
            dp1[i] += length;
        }
        // Longest decreasing subsequence => lis -> right to left
        for(int i=n-2; i>=0; i--){
            int length = 0;
            for(int j=i+1; j<n; j++){
                if(arr[i] > arr[j]) {
                    length = Math.max(length, dp2[j]);
                }
            }
            dp2[i] += length;
        }
        int maxLength = 0;
        for(int i=0; i<n; i++) {
            // for strictly increasing and decreasing
            if(dp1[i] != 1 && dp2[i] != 1) maxLength = Math.max(maxLength, (dp1[i] + dp2[i]-1));
        }
        return maxLength;
    }
}