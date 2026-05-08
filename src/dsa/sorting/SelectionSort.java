package dsa.sorting;

import java.util.Scanner;

public class SelectionSort {
    static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n]; // empty array of size 4;
        System.out.print("Enter the elements of the array : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        print(arr);
        selectionSort(arr);
        print(arr);
    }
    private static void print(int[] arr){
        for(int ele : arr){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
    private static void selectionSort(int[] arr){
        // TC = O(n^2) in all cases

        for(int i=0; i<arr.length-1; i++){ // O(n-1)
            int mni = i;
            for(int j=i; j<arr.length; j++){ // O(n-i)
                if(arr[j] < arr[mni]) mni = j;
            }
            // swap the smallest element with first element
            int temp = arr[i];
            arr[i] = arr[mni];
            arr[mni] = temp;
        }
    }
}
