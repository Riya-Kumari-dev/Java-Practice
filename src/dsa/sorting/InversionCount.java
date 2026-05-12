package dsa.sorting;

import java.util.Scanner;

public class InversionCount {
    //  Inversion count is the number of pairs of elements (i, j) such that i < j and arr[i] > arr[j].
    static int count;
    static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements of the array : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        count = 0;
        inversion(arr);
        System.out.println("Total inversions counts are "+count);
    }
    private static void inversion(int[] arr){
        int n = arr.length;
        if(n==1) return;
        // step 1 : split the array into two parts
        int[] a = new int[n/2];
        int[] b = new int[n-n/2];
        for(int i=0; i<n/2; i++){
            a[i] = arr[i];
        }
        for(int i=0; i<n-n/2; i++){
            b[i] = arr[n/2+i];
        }
        // step 2 : magic i.e. recursion
        inversion(a);
        inversion(b);
        // step 3:  merge
        merge(a,b,arr);
    }
    private static void merge(int[] arr, int[] brr, int[] res){
        int i=0;
        int j=0;
        int k=0;
        while(i<arr.length && j<brr.length){
            if(arr[i]<=brr[j]) {
                res[k] = arr[i];
                i++;
            }
            else{
                count += (arr.length-i);
                res[k] = brr[j];
                j++;
            }
            k++;
        }
        while(i<arr.length) res[k++] = arr[i++];
        while(j<brr.length) res[k++] = brr[j++];
    }
}