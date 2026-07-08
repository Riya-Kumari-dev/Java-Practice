package dsa.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CountNumberOfNiceSubarrays {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter k : ");
        int k = sc.nextInt();
        System.out.println("Number of nice subarrays in "+ Arrays.toString(arr)+" is "+numberOfSubarrays(arr, k));
    }

    // A continuous subarray is called nice if there are k odd numbers on it.

    // using sliding window
    // TC = O(n)
    private static int  numberOfSubarrays(int[] arr, int k) {
        int n = arr.length;
        int a = 0;
        int b = 0;
        int i=0;
        int j=0;
        int odd = 0;
        int count = 0;
        while(i<n && arr[i]%2 == 0) i++;
        // now i is at the 1st odd one position
        while(j<n && odd < k) {
            if(arr[j]%2 == 1) odd++;
            j++;
        }
        j--;
        // now j is at kth odd  position
        if(odd < k) return 0;
        b = j+1;
        while(b< n && arr[b] % 2 != 1) b++;
        b--;
        // now b is just before the (k+1)th odd position

        // sliding window
        while(b<n){
            // evaluate the answer
            count += (i-a+1) * (b-j+1);
            // next iteration
            a = i+1;
            i++;
            while(i<n && arr[i]%2 == 0) i++;
            j=b+1;
            b = j+1;
            while(b< n && arr[b] % 2 != 1) b++;
            b--;
        }
        return count;
    }

    // using prefix sum and hashmap
    // TC = O(n) , SC = O(n)
//    private static int  numberOfSubarrays(int[] arr, int k) {
//        int n = arr.length;
//        int count = 0;
//        for(int i=0; i<n; i++) arr[i] %= 2; // change the odd to 1 and even to zero
//
//        // prefix sum
//        for(int i=1; i<n; i++) arr[i] += arr[i-1];
//
//        // map for arr[i], first occurrence
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for(int i=0; i<n; i++){
//            if(!map.containsKey(arr[i])) map.put(arr[i], i);
//
//            int a = 0; // a denotes (k-1)th ones till now
//            if(map.containsKey(arr[i] - k)) a = map.get(arr[i]-k);
//
//            int b = 0; // b denotes that (k-2)th ones till now
//            if(map.containsKey(arr[i]-k+1)) b = map.get(arr[i]-k+1);
//
//            if(arr[i] == k){ // exact k ones aa gye hai
//                count += (b-a+1);
//            }
//            if(arr[i] > k){
//                count += (b-a);
//            }
//        }
//        return count;
//    }
}