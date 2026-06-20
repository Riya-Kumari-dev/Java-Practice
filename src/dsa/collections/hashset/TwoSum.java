package dsa.collections.hashset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class TwoSum {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter target : ");
        int target = sc.nextInt();
        if(twoSum(arr, target)) System.out.println("Yes, "+ Arrays.toString(arr)+" contains two elements equal to "+target);
        else System.out.println("No, "+ Arrays.toString(arr)+" does not contain two elements equal to "+target);
    }

    private static boolean twoSum(int[] arr, int target) {
        HashSet<Integer> s = new HashSet<>();
        for(int ele : arr){
            if(!s.contains(target-ele)) s.add(ele);
            else return true;
        }
        return false;
    }
}