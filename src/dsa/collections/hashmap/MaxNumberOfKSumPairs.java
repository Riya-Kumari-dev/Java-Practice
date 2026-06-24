package dsa.collections.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MaxNumberOfKSumPairs {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the given array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter k : ");
        int k = sc.nextInt();

        System.out.println("Maximum Number of operations are "+maxOperations(arr, k)+" such that no pair available in "+ Arrays.toString(arr)+" whose sum equal to "+k);
    }

    private static int maxOperations(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int ele : arr){
            int rem = k-ele;
            if(map.containsKey(rem) && map.get(rem)>0) {
                count++;
                map.put(rem, map.getOrDefault(rem, 0)-1);
            }
            else{
                map.put(ele, map.getOrDefault(ele, 0)+1);
            }
        }
        return count;
    }
}