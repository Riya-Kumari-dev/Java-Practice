package dsa.slidingwindow;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSubarraySumOfSizeK {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the size of the subarray : ");
        int k = sc.nextInt();
        System.out.println("Maximum subarray sum in "+ Arrays.toString(arr)+" of size "+k+" is "+maximumSubarraySum(arr, k));
    }

    // sliding window technique
    // TC = O(n)
    private static int maximumSubarraySum(int[] arr, int k) {
        int n = arr.length;
        // find the sum for the initial window
        int sum = 0;
        for(int i=0; i<k; i++){ // TC = O(k)
            sum += arr[i];
        }
        int maxSum = sum;
        int i=1;
        int j = k;
        while(j<n){ // TC = O(n-k)
            // two consecutive windows of size k have k-1 elements common
            sum = sum - arr[i-1] + arr[j];
            maxSum = Math.max(sum, maxSum);
            i++;
            j++;
        }
        return maxSum;
    }

    // Brute force
    // TC = O(n*k)
//    private static int maximumSubarraySum(int[] arr, int k) {
//        int n = arr.length;
//        int maxSum = Integer.MIN_VALUE;
//        // Number of subarrays of size k is n-k+1
//        for(int i=0; i<n-k+1; i++){
//            int sum = 0;
//            for(int j=i; j<i+k; j++){
//                sum += arr[j];
//            }
//            maxSum = Math.max(maxSum, sum);
//        }
//        return maxSum;
//    }
}