package dsa.arrays.array;

import java.util.Scanner;

public class SecondMaximumOfTheArray {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Second maximum element in the given array is "+secondMax(arr));
    }

    private static int secondMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        for(int ele : arr){
            max = Math.max(ele, max);
        }
        for(int ele : arr){
            if(smax < ele && ele != max){
                smax = ele;
            }
        }
        return smax;
    }
}
