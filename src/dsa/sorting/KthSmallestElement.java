package dsa.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class KthSmallestElement {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n]; // empty array of size 4;
        System.out.print("Enter the elements of the array : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter k : ");
        int k = sc.nextInt();
        System.out.println(Arrays.toString(arr));
        System.out.print(quickSelect(arr, 0, arr.length - 1, k));
    }

    private static int quickSelect(int[] arr, int lo, int hi, int k) {
        // code here
        if(lo > hi) return -1;
        int correctIdx = partition(arr, lo, hi);
        if(correctIdx+1 == k) return arr[correctIdx];
        else if(correctIdx+1 > k) return quickSelect(arr, lo, correctIdx - 1, k);
        else return quickSelect(arr, correctIdx + 1, hi, k);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // TC = O(n)
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