package dsa.prefixsum;

import java.util.Arrays;
import java.util.Scanner;

public class PivotIndex {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Pivot index : "+pivotIndex(arr));
    }

    // The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

    // TC = O(n)
    private static int pivotIndex(int[] arr) {
        int n = arr.length;
        for(int i=1; i<n; i++) arr[i] += arr[i-1];

        int leftSum = 0;
        int rightSum = 0;
        for(int i=0; i<n; i++){
            if(i>0) leftSum = arr[i-1];
            rightSum = arr[n-1] - arr[i];
            if(leftSum == rightSum) return i;
        }
        return -1;
    }

    // Brute force
    // TC = O(n^2)
//    private static int pivotIndex(int[] arr) {
//        int n = arr.length;
//        for(int i=0; i<n; i++){
//            int leftSum = 0;
//            for(int j=0; j<i; j++){
//                leftSum += arr[j];
//            }
//            int rightSum = 0;
//            for(int j=i+1; j<n; j++){
//                rightSum += arr[j];
//            }
//            if(leftSum == rightSum) return i;
//        }
//        return -1;
//    }
}