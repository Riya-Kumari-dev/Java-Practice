package dsa.arrays.array;

import java.util.Scanner;

public class MaximumOfAnArray {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the dsa.arrays.array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter "+n+" elements for the dsa.arrays.array : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        int mx = Integer.MIN_VALUE;
        for(int ele : arr){
            if(ele > mx) mx = ele;
        }
        System.out.print("The maximum element in the given dsa.arrays.array is "+mx);
    }
}
