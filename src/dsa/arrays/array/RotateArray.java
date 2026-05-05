package dsa.arrays.array;

import java.util.Scanner;

public class RotateArray {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
        System.out.print("Enter the number of rotation to be executed : ");
        int k = sc.nextInt();
        rotate(k, arr);
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

    private static void rotate(int k, int[] arr) {
        int n = arr.length;
        k = k% n;
        reverse(arr, 0, k-1);
        reverse(arr, k, n-1);
        reverse(arr, 0, n-1);
    }

    private static void reverse(int[] arr, int i, int j) {
        while(i<j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}