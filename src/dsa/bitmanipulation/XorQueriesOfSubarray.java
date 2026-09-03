package dsa.bitmanipulation;

import java.util.Arrays;
import java.util.Scanner;

public class XorQueriesOfSubarray {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the given array : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the total number of query : ");
        int m = sc.nextInt();
        int[][] queries = new int[m][2];
        System.out.print("Enter " + m + " queries : ");
        for(int i = 0; i< m; i++){
            for(int j=0; j<1; j++){
                queries[i][0] = sc.nextInt();
                queries[i][1] = sc.nextInt();
            }
        }
        int[] ans = xorQueries(arr, queries);
        System.out.println(Arrays.toString(ans));
    }

    // TC = O(m+n)
    private static int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int m = queries.length;
        for(int i=1; i<n; i++){ // arr is now prefix xor
            arr[i] ^= arr[i-1];
        }
        int[] ans = new int[m];
        for(int i=0; i<m; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            if(start == 0) ans[i] = arr[end];
            else ans[i] = arr[start-1] ^ arr[end];
        }
        return ans;
    }

    // TC = O(n*m)
//    private static int[] xorQueries(int[] arr, int[][] queries) {
//        int n = arr.length;
//        int m = queries.length;
//        int[] ans = new int[m];
//        for(int i=0; i<m; i++){
//            int start = queries[i][0];
//            int end = queries[i][1];
//            int xor = 0;
//            for(int j=start; j<=end; j++){
//                xor ^= arr[j];
//            }
//            ans[i] = xor;
//        }
//        return ans;
//    }
}