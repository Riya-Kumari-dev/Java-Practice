package dsa.arrays.array;

import java.util.Scanner;

public class Segregate0s1s {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n]; // 1 based indexing
        System.out.print("Enter " + n + " elements for the array consisting only 1 and 0 : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
        segregate(arr);
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }
    // two pointer technique
    private static void segregate(int[] arr) {
        int i = 0;
        int j=arr.length-1;
        while(i<j){
            if(arr[i] == 0) i++;
            else if(arr[j] == 1) j--;
            else{
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }

        }
    }
//    private static void segregate(int[] arr) {
//        int zeroes = 0;
//        for(int ele : arr){
//            if(ele == 0) zeroes++;
//        }
//        for(int i=0; i<zeroes; i++){
//            arr[i] = 0;
//        }
//        for(int i=zeroes; i<arr.length; i++){
//            arr[i] = 1;
//        }
//    }
}
