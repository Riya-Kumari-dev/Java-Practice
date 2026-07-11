package dsa.binarysearch;

import java.util.Scanner;

public class LowerAndUpperBound {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter a target to be searched : ");
        int target = sc.nextInt();

        System.out.println("Lower bound and upper bound of "+target+" are "+lowerBound(arr, target)+" and "+upperBound(arr, target)+" respectively.");
    }

    // Upper bound is the rightmost index where a value can be inserted in a sorted array, and the array will still be sorted.
    // minimum index such tha arr[ub] > target
    private static int upperBound(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length-1;
        int ub = arr.length;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid] > target) {
                ub = Math.min(ub, mid);
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return ub;
    }

    // Lower bound is the left most index where a value can be inserted in a sorted array, and the array will still be sorted.
    // minimum index such that arr[lb] >= target
    private static int lowerBound(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length-1;
        int lb = arr.length;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid] >= target) {
                lb = Math.min(lb, mid);
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return lb;
    }
}