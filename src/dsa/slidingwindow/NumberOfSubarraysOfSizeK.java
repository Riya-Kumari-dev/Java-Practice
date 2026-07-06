package dsa.slidingwindow;

import java.util.Arrays;
import java.util.Scanner;

public class NumberOfSubarraysOfSizeK {
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
        System.out.print("Enter the threshold : ");
        int t = sc.nextInt();
        System.out.println("Number of sub-arrays in " + Arrays.toString(arr)+" of size "+ k+" and average >= "+t+" is "+numOfSubarrays(arr, k, t));
    }

    // TC = O(n)
    private static int numOfSubarrays(int[] arr, int k, int t) {
        int n = arr.length;
        // find the avg for the initial window
        double avg = 0;
        double sum = 0;
        for(int i=0; i<k; i++){ // TC = O(k)
            sum += arr[i];
        }
        int count = 0;
        avg = sum/k;
        if(avg >= t) count++;
        int i=1;
        int j = k;
        while(j<n){ // TC = O(n-k)
            // two consecutive windows of size k have k-1 elements common
            sum = sum - arr[i-1] + arr[j];
            avg = sum / k;
            if(avg >= t) count++;
            i++;
            j++;
        }
        return count;
    }
}