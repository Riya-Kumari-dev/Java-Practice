package dsa.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n]; // empty array of size 4;
        System.out.print("Enter the elements of the array : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr, int lo, int hi) {
        // code here
        if(lo>=hi) return;
        int correctIdx = partition(arr,lo, hi);
        quickSort(arr, lo, correctIdx-1);
        quickSort(arr, correctIdx+1, hi);
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // TC = O(n*log(n)) => avg case
    // worst case => TC = O(n^2)
    // SC = O(log(n)) => recursive call stack
//    private static int partition(int[] arr, int lo, int hi) {
//
//        // code here
//        int smallCount = 0;
//        for(int i=lo+1; i<=hi; i++){
//            if(arr[i] <= arr[lo]) smallCount++;
//        }
//        int correctIdx = smallCount+lo;
//        swap(arr, lo, correctIdx);
//        int i=lo, j = hi;
//        while(i<correctIdx && j> correctIdx){
//            if(arr[i] > arr[correctIdx] && arr[j] <= arr[correctIdx]){
//                swap(arr, i, j);
//                i++;
//                j--;
//            }
//            else if(arr[i] <= arr[correctIdx]) i++;
//            else j--;
//        }
//        return correctIdx;
//    }

    // randomization
    // TC = O(n*log(n))
    // worst => TC = O(n*log(n))
    //SC = O(log(n))
    private static int partition(int[] arr, int lo, int hi) {
        int smallCount = 0;
        int mid = (lo+hi)/2;
        for(int i=lo; i<=hi; i++){
            if(i==mid) continue;
            if(arr[i] <= arr[mid]) smallCount++;
        }
        int correctIdx = smallCount+lo;
        swap(arr, mid, correctIdx);
        int i=lo, j = hi;
        while(i<correctIdx && j> correctIdx){
            if(arr[i] > arr[correctIdx] && arr[j] <= arr[correctIdx]){
                swap(arr, i, j);
                i++;
                j--;
            }
            else if(arr[i] <= arr[correctIdx]) i++;
            else j--;
        }
        return correctIdx;
    }
}