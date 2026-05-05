package dsa.arrays.array;

import java.util.Scanner;

public class WaveArray {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array (sorted) : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
        wave(arr);
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

    private static void wave(int[] arr) {
        // arr[0] >= arr[1] <= arr[2] >= arr[3]... like a wave
        int n = arr.length;
        for(int i=0; i<n-1; i+=2) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }
}
