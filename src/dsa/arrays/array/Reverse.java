package dsa.arrays.array;

import java.util.Scanner;

public class Reverse {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int ele : arr){
            System.out.print(ele+" ");
        }
        System.out.println();
        reverse(arr);
        System.out.println("After reversing ");
        for(int ele : arr){
            System.out.print(ele+" ");
        }
    }

    private static void reverse(int[] arr) {
        int i=0;
        int j=arr.length-1;
        while(i<j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
