package dsa.slidingwindow;

import java.util.Arrays;
import java.util.Scanner;

public class MaxConsecutives3 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter at most flips that can be performed : ");
        int k = sc.nextInt();
        System.out.println("Longest Subarray of 1's in "+ Arrays.toString(arr)+" after flipping at most "+k+" zeroes is of length "+longestOnes(arr, k));
    }

    private static int longestOnes(int[] arr, int k) {
        int n = arr.length;
        int i=0; int j=0;
        int flips = 0;
        int maxLen = 0;
        int len = 0;
        while(j<n){
            if(arr[j] == 1) j++;
            else if(arr[j] == 0){
                if(flips < k){
                    flips++;
                    j++;
                }
                else{
                    // evaluate the length
                    len = j-i;
                    maxLen = Math.max(len, maxLen);
                    // shrink the window
                    while(arr[i] == 1) i++; // arr[i] == 0
                    i++;
                    j++;
                }
            }
        }
        len = j-i;
        maxLen = Math.max(len, maxLen);
        return maxLen;
    }
}