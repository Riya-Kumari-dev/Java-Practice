package dsa.sorting;

import java.util.Scanner;

public class BubbleSortOptimized {
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
        bubbleSort(arr);
        print(arr);
    }
    private static void print(int[] arr){
        for(int ele : arr){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
    private static void bubbleSort(int[] arr){
        int n = arr.length;
        // best case TC = O(n)
        // avg case TC = O(n^2)
        // worst case TC = O(n^2)
        for(int i=0; i<n-1; i++){ // TC = O(n*(n-1)/2)
            //boolean flag = true;
//            for(int k=0; k<n-1; k++){
//                if(arr[k] > arr[k+1]) {
//                    flag = false;
//                    break;
//                }
//            }
//            if(flag) break;
            int swap = 0;
            for(int j=0; j<n-i-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap++;
                    //flag = false;
                }
            }
            if(swap == 0) break;
        }
    }
}
