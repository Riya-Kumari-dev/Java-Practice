package dsa.slidingwindow;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumSizeSubarraySum {
     static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter target : ");
        int target = sc.nextInt();
        System.out.println("Minimum size subarray sum in "+ Arrays.toString(arr)+" is "+minSubarrayLen(arr, target));
    }

    private static int minSubarrayLen(int[] arr, int target) {
        int n = arr.length;
        int minLen = Integer.MAX_VALUE;
        int i=0;
        int j=0;
        int sum = 0;
        while(j<n){
            sum += arr[j];
            while(sum >= target){
                minLen = Math.min(minLen, j-i+1);
                // for next iteration
                sum -= arr[i];
                i++;
            }
            j++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    // Brute force
    // TC = O(n^2)
//    private static int minSubarrayLen(int[] arr, int target) {
//        int n = arr.length;
//        int minLen = Integer.MAX_VALUE;
//        for(int i=0; i<n; i++){
//            int sum = 0;
//            int j=i;
//            while(j<n && sum < target) sum += arr[j++];
//            j--;
//            if(sum >= target) minLen = Math.min(j-i+1, minLen);
//        }
//        return minLen == Integer.MAX_VALUE ? 0 : minLen;
//    }
}