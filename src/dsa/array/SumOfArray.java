package dsa.array;

import java.util.Scanner;

public class SumOfArray {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter "+n+" elements for the array : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        for(int ele : arr){
            sum += ele;
        }
        System.out.print("The sum of all the elements of the given array is "+sum);
    }
}
