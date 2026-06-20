package dsa.collections.hashset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class DistinctElements {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("There are total of "+distinctElements(arr)+" elements in "+ Arrays.toString(arr));
    }

    private static int distinctElements(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele : arr) set.add(ele);
        return set.size();
    }
}