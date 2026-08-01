package dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LargestDivisibleSubset {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the given array : ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println("Largest divisible subset in "+Arrays.toString(arr)+" is "+largestDivisibleSubset(arr));
    }
    private static List<Integer> largestDivisibleSubset(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLength = 1;
        for(int i=n-2; i>=0; i--){
            int length = 0;
            for(int j=i+1; j<n; j++){
                if(arr[j] % arr[i] == 0) {
                    length = Math.max(length, dp[j]);
                }
            }
            dp[i] += length;
            maxLength = Math.max(dp[i], maxLength);
        }
        int idx = -1;
        for(int i=0; i<n; i++) {
            if(dp[i] == maxLength) {
                idx = i;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[idx]);
        maxLength--;
        idx++;
        while(idx<n){
            if(dp[idx] == maxLength && arr[idx] % ans.getLast() == 0) {
                ans.add(arr[idx]);
                maxLength--;
            }
            idx++;
        }
        return ans;
    }
}
