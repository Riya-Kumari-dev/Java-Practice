package dsa.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

import static dsa.dynamicprogramming.SubsetSum.isSubsetSum;

public class PartitionEqualSubsetSum {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter "+n+" elements for the array : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        if(!canPartition(arr))
            System.out.println("No, " + Arrays.toString(arr) + " cannot divide into two subsets such that their sums are equal.");
        else System.out.println("Yes, " + Arrays.toString(arr) + " can divide into two subsets such that their sums are equal.");
    }

    private static boolean canPartition(int[] arr) {
        int sum = 0;
        for(int ele : arr) sum += ele;
        if(sum % 2 != 0) return false; // agar total sum is odd then it is impossible to divide into two equal subset sum
        return isSubsetSum(arr, sum/2);
    }
}