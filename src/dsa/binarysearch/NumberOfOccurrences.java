package dsa.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class NumberOfOccurrences {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter a target : ");
        int target = sc.nextInt();

        int ans = countFreq(arr, target);
        if(ans == -1) System.out.println(target+" is not present in "+ Arrays.toString(arr));
        else System.out.println("Total number of occurrences of "+target+" in "+Arrays.toString(arr)+" are "+ans);
    }

    private static int countFreq(int[] arr, int target) {
        // first occurrence
        int lo = 0;
        int hi = arr.length-1;
        int first = -1;
        while(lo <= hi){
            int mid = lo +(hi-lo)/2;
            if(arr[mid] == target){
                if(mid-1 >= 0 && arr[mid-1] == target){ // then mid is not the first occurrence => reduce the search space
                    hi = mid-1;
                }
                else { // mid is the first occurrence
                    first = mid;
                    break;
                }
            }
            else if(arr[mid] > target) hi = mid-1; // go left
            else lo = mid + 1; // arr[mid] < target => go right
        }

        // last occurrence
        lo = 0;
        hi = arr.length-1;
        int last = -1;
        while(lo <= hi){
            int mid = lo +(hi-lo)/2;
            if(arr[mid] == target){
                if(mid+1 < arr.length && arr[mid+1] == target){ // then mid is not the last occurrence => reduce the search space
                    lo = mid+1;
                }
                else { // mid is the last occurrence
                    last = mid;
                    break;
                }
            }
            else if(arr[mid] > target) hi = mid-1; // go left
            else lo = mid + 1; // arr[mid] < target => go right
        }
        return last-first+1;
    }
}