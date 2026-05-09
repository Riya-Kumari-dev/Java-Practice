package dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SubsetsOfArray {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n]; // 0 based indexing
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> finalAns = new ArrayList<>();
        subsets(arr, 0,new ArrayList<>(), finalAns);
        System.out.println("Subsets of "+ Arrays.toString(arr)+" are "+finalAns);
    }
    // TC = O(2^n)
    private static void subsets(int[] arr, Integer i, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> finalAns) {
        if(i==arr.length) {
            finalAns.add(new ArrayList<>(ans));
            return;
        }
        // skip
        subsets(arr,i+1,ans, finalAns);
        // take
        ans.add(arr[i]);
        subsets(arr, i+1, ans, finalAns);
        ans.removeLast();
    }
}