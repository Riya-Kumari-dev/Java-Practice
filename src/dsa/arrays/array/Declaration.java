package dsa.arrays.array;

import java.util.Scanner;

public class Declaration {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[4]; // empty dsa.arrays.array of size 4;
        System.out.print("Enter 4 elements of the array : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
