package dsa.prefixsum;

import java.util.Arrays;
import java.util.Scanner;

public class ScoreOfAllPrefix {
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
        System.out.println(Arrays.toString(findPrefixScore(arr)));
    }

    //  conversion array conver of an array arr as follows :
    //conver[i] = arr[i] + max(arr[0..i]) where max(arr[0..i]) is the maximum value of arr[j] over 0 <= j <= i.
    //We also define the score of an array arr as the sum of the values of the conversion array of arr.
    //Given a 0-indexed integer array nums of length n, return an array ans of length n where ans[i] is the score of the prefix nums[0..i].


    private static long[] findPrefixScore(int[] arr) {
        int n = arr.length;
        // max array contains ele such as ele + max element till that index
        long[] max = new long[n];
        int mx = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            mx = Math.max(mx, arr[i]);
            max[i] = arr[i] + mx;
        }
        //build prefix sum array of max array
        for(int i=1; i<n; i++){
            max[i] += max[i-1];
        }
        return max;
    }
}
