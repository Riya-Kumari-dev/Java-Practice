package dsa.prefixsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SubarraySumEqualsK {
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

        System.out.println("Total number of subarrays of "+ Arrays.toString(arr)+" having sum equal to "+k+" is "+subarraySum(arr, k));
    }

    // TC = O(n), AS = O(n)
    private static int subarraySum(int[] arr, int k) {
        // built prefix sum to find the sum till that elements
        for(int i=1; i<arr.length; i++){
            arr[i] += arr[i-1];
        }
        int count = 0;
        // store the ele, freq
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : arr){
            int rem = ele - k;
            if(ele == k) count++;
            if(map.containsKey(rem)) { // if rem exists then every occurrence of it forms a valid subarray.
                count += map.get(rem);
            }
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        return count;
    }

    // TC = O(n^2)
//    private static int subarraySum(int[] arr, int k) {
//        int count = 0;
//        for(int i=0; i<arr.length; i++){
//            int sum = 0;
//            for(int j=i; j<arr.length; j++){
//                sum += arr[j];
//                if(sum == k) count++;
//            }
//        }
//        return count;
//    }
}