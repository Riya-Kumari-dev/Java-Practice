package dsa.prefixsum;

import java.util.Arrays;
import java.util.Scanner;

public class ProductOfArrayExceptSelf {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Product of "+Arrays.toString(arr)+" except self "+Arrays.toString(productExceptSelf(arr)));
    }

    // TC = O(n) , SC = O(n) => only one extra array used
    private static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        // built prefix product array except self
        int[] pre = new int[n];
        pre[0] = 1;
        for(int i=1; i<n; i++){
            pre[i] = arr[i-1]* pre[i-1];
        }
        int suf = 1;
        for(int i=n-2; i>=0; i--){
            suf *= arr[i+1];
            pre[i] *= suf;
        }
        return pre;
    }


//    // TC = O(n) , SC = O(n)
//    private static int[] productExceptSelf(int[] arr) {
//        int n = arr.length;
//        // built prefix product array except self
//        int[] pre = new int[n];
//        pre[0] = 1;
//        for(int i=1; i<n; i++){
//            pre[i] = arr[i-1]* pre[i-1];
//        }
//        // built suffix product array except self
//        int[] suf = new int[n];
//        suf[n-1] = 1;
//        for(int i=n-2; i>=0; i--){
//            suf[i] = arr[i+1] * suf[i+1];
//        }
////        int[] ans = new int[n]; // pre * suf products of that element excluding itself
////        for(int i=0; i<n; i++){
////            ans[i] = pre[i] * suf[i];
////        }
//
//        // make prefix array itself the ans
//        for(int i=0; i<n; i++){
//            pre[i] *= suf[i];
//        }
//        return pre;
//    }
}