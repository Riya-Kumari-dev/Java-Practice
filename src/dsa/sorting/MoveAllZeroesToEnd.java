package dsa.sorting;

import java.util.Scanner;

public class MoveAllZeroesToEnd {
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
        moveZerosToEnd(arr);
        print(arr);
    }

    private static void moveZerosToEnd(int[] arr) {
        int n = arr.length;
//        for(int i=0; i<n-1; i++){
//            int swap = 0;
//            for(int j=0; j<n-i-1; j++) {
//                if (arr[j] == 0) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                    swap++;
//                }
//            }
//            if(swap == 0) break;
//        }
        // method 2 => optimized
        int j = 0;
        for(int i=0; i<n; i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++; // j will only increase on nonzero
            }
        }
    }

    private static void print(int[] arr){
        for(int ele : arr){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
}
