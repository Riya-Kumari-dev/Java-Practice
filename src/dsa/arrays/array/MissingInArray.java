package dsa.arrays.array;

import java.util.Scanner;

public class MissingInArray {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n]; // 1 based indexing
        System.out.print("Enter " + n + " elements for the array (1,"+(n+1)+") taking one missing : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int ele : arr){
            System.out.print(ele+" ");
        }
        System.out.println();
        System.out.println("The element missing in the given array : "+missingInArray(arr));
    }


    private static int missingInArray(int[] arr) {
        long n = arr.length+1;
        long sum = n*(n+1)/2; // should be if all present from 1 to n // runtime error for long cases if int => n can very large
        long arraySum = 0;
        for(int ele : arr){
            arraySum += ele;
        }
        return (int)(sum - arraySum);
    }
}
