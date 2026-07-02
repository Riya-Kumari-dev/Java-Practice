package dsa.prefixsum;

import java.util.Arrays;
import java.util.Scanner;

public class RunningSumOf1DArray {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Prefix sum of "+Arrays.toString(arr)+" is "+Arrays.toString(runningSum(arr)));
    }

    // AS = O(1), TC = O(n)
    private static int[] runningSum(int[] arr) {
        int n = arr.length;
        for(int i=1; i<n; i++){
            arr[i] += arr[i-1];
        }
        return arr;
    }

    // using AS = O(n) , TC = O(n)
//    private static int[] runningSum(int[] arr) {
//        int n = arr.length;
//        int[] pre = new int[n];
//        pre[0] = arr[0];
//        for(int i=1; i<n; i++){
//            pre[i] = pre[i-1] + arr[i];
//        }
//        return pre;
//    }
}