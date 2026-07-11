package dsa.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    // Binary Search is used to search a given element in a sorted space.
    // It is used to reduce the search space in half after every turn
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter a target to be searched : ");
        int target = sc.nextInt();

        int ans = binarySearch(arr, target);
        if(ans == -1) System.out.println(target+" is not present in "+ Arrays.toString(arr));
        else System.out.println(target+" is present at index "+ans+" in "+Arrays.toString(arr));
    }

    // TC = O(n)
    private static int binarySearch(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length-1;
        while(lo <= hi){
            int mid = lo +(hi-lo)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) hi = mid-1; // go left
            else lo = mid + 1; // arr[mid] < target => go right
        }
        return -1;
    }
}