package dsa.sorting;

import java.util.Scanner;

public class SortedOrNot {
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
        System.out.println(sorted(arr));
    }

    private static boolean sorted(int[] arr) {
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] > arr[i+1]) return false;
        }
        return true;
    }

    private static void print(int[] arr){
        for(int ele : arr){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
}
