package dsa.sorting;

import java.util.Scanner;

public class KthSmallest {
    static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n]; // empty array of size 4;
        System.out.print("Enter the elements of the array : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter k : ");
        int k = sc.nextInt();
        print(arr);
        System.out.println("The "+k+"th smallest element is : "+kthSmallest(arr, k));
    }

    private static int kthSmallest(int[] arr, int k) {
        for(int i=0; i<k; i++){ // O(n-1)
            int mni = i;
            for(int j=i; j<arr.length; j++){ // O(n-i)
                if(arr[j] < arr[mni]) mni = j;
            }
            // swap the smallest element with first element
            int temp = arr[i];
            arr[i] = arr[mni];
            arr[mni] = temp;
        }
        return arr[k-1];
    }

    private static void print(int[] arr){
        for(int ele : arr){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
}
