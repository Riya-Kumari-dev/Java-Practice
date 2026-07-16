package dsa.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class PeakIndexInAMountainArray {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int peak = peakIndex(arr);

        if(peak == -1) System.out.println("There is no peak element present in "+ Arrays.toString(arr));
        else System.out.println("Peak index in "+Arrays.toString(arr)+" is "+peak);
    }

    // TC = O(log(n))
    private static int peakIndex(int[] arr) {
        int lo = 1;
        int hi = arr.length-2;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) return mid;
            else if(arr[mid] > arr[mid-1] && arr[mid] < arr[mid+1]) { // it is increasing , so no need to check for peak at left => go right
                lo = mid+1;
            }
            else{ // arr[mid] < arr[mid-1] => decreasing, that means peak pehle hi hoga => go left
                hi = mid-1;
            }
        }
        return -1;
    }

    // TC = O(n)
//    private static int peakIndex(int[] arr) {
//        for(int i=1; i<arr.length-1; i++){
//            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]) return i;
//        }
//        return -1;
//    }
}