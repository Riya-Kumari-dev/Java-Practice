package dsa.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class KthMissingPositiveNumber {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter k : ");
        int k = sc.nextInt();
        System.out.println(k+"th missing positive number in "+ Arrays.toString(arr)+" is "+findKthPositive(arr, k));
    }

    private static int findKthPositive(int[] arr, int k) {
        int lo = 0;
        int hi = arr.length-1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            int missed = arr[mid] - (mid+1);
            if(missed < k) lo = mid+1;
            else hi = mid-1;
        }
        // kth missing number is between arr[hi] and arr[lo]
        // maths part
        // kth missing number = arr[hi] + extra;
        // extra = k-missed numbers till hi => k - (arr[hi] - (hi+1))
        // => kth missing = arr[hi] + k - (arr[hi] - (hi+1))
        // => k+hi +1
        // =>  k + lo
        return k+lo;
    }
}