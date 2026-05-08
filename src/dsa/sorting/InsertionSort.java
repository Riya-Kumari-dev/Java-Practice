package dsa.sorting;

import java.util.Scanner;

public class InsertionSort {
    static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements of the array : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        print(arr);
        insertionSort(arr);
        print(arr);
    }
    private static void print(int[] arr){
        for(int ele : arr){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
    private static void insertionSort(int[] arr){
        /*SC = O(1);
        TC = O(n*(n-1)/2) ~ O(n^2) (avg and worst)
        Best case  1 2 3 5 8 => TC = O(n)
        */
        int i=1;
        int j=1;
        while(i<arr.length){
            // there are two parts of array, sorted and unsorted
            // first element of unsorted part will be inserted in the right place of the sorted part
            while(j>0 && arr[j] < arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
            i++;
            j = i;
        }
    }
}
