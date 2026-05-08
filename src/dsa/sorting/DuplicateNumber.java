package dsa.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class DuplicateNumber {
    static void main(String[] args) {
        //You are given an array arr[] of size n - 1 that contains distinct integers in the range from 1 to n+1 (inclusive)
        // with one element double
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements of the array (1 to n) : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Duplicate number in "+ Arrays.toString(arr)+" is "+duplicateNumber(arr));
    }

    private static int duplicateNumber(int[] arr) {
        int i=0;
        while(i<arr.length){
            int correctIdx = arr[i] -1;
            if(arr[i] != i+1){
                if(arr[i] != arr[correctIdx]){
                    int temp = arr[i];
                    arr[i] = arr[correctIdx];
                    arr[correctIdx] = temp;
                }
                else return arr[i];
            }
            else i++;
        }
        return -1;
    }
}
