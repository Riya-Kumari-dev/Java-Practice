package dsa.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MissingNumber {
    static void main(String[] args) {
        //You are given an array arr[] of size n - 1 that contains distinct integers in the range from 1 to n+1 (inclusive)
        // with one element missing.
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements of the array (1 to n+1) : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Missing number in "+ Arrays.toString(arr)+" is "+missingNumber(arr));
    }

    private static int missingNumber(int[] arr) {
        int i=0;
        while(i<arr.length){
            if(arr[i] > arr.length || arr[i] == i+1) i++;
            else{
                int correctIdx = arr[i]-1;
                int temp = arr[i];
                arr[i] = arr[correctIdx];
                arr[correctIdx] = temp;
            }
        }
        for(i=0; i<arr.length; i++){
            if(arr[i] != i+1) return i+1;
        }
        return arr.length+1;
    }
}
