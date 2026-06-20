package dsa.collections.hashset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class MissingElements {

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Missing elements in "+Arrays.toString(arr)+" are "+missingElements(arr));
    }


    // Originally, nums contained every integer within a certain range.
    // However, some integers might have gone missing from the array.
    //The smallest and largest integers of the original range are still present in nums.
    //Return a sorted list of all the missing integers in this range.
    // If no integers are missing, return an empty list.


    private static ArrayList<Integer> missingElements(int[] arr) {
        int lo = 101;
        int hi = -1;
        for(int ele : arr){
            lo = Math.min(ele, lo);
            hi = Math.max(ele, hi);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> s = new HashSet<>();

        for(int ele : arr) s.add(ele);

        for(int i=lo; i<=hi; i++){
            if(!s.contains(i)) ans.add(i);
        }
        return ans;
    }

//    private static ArrayList<Integer> missingElements(int[] arr) {
//        int lo = 101;
//        int hi = -1;
//        for(int ele : arr){
//            lo = Math.min(ele, lo);
//            hi = Math.max(ele, hi);
//        }
//        ArrayList<Integer> ans = new ArrayList<>();
//        int[] a = new int[hi-lo+1];
//        for(int ele : arr){
//            if(ele >= lo && ele <= hi) a[ele-lo] = 1;
//        }
//        for(int i=lo; i<=hi; i++){
//            if(a[i-lo] == 0) ans.add(i);
//        }
//        return ans;
//    }
}