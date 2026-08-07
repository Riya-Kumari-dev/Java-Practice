package dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Permutations {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter "+n+" elements for the given array : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Permutations of "+ Arrays.toString(arr)+" are "+permutation(arr));
    }
    // TC = O(n*n!) , AS = O(1)
    private static ArrayList<ArrayList<Integer>> permutation(int[] arr){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        helper(arr, 0, ans);
        return ans;
    }
    private static void helper(int[] arr, int idx, ArrayList<ArrayList<Integer>> ans){
        if(idx == arr.length-1){
            ArrayList<Integer> copy = new ArrayList<>();
            for (int ele : arr) copy.add(ele);
            ans.add(copy);
            return;
        }
        for(int i = idx; i< arr.length; i++){
            swap(i, idx, arr);
            helper(arr, idx+1, ans);
            swap(i,idx, arr);

        }
    }
    public static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // TC = O(n*n!) , AS = O(n)
//    private static ArrayList<ArrayList<Integer>> permutation(int[] arr){
//        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//        int n = arr.length;
//        boolean[] taken = new boolean[n]; // AS = O(n)
//        ArrayList<Integer> v = new ArrayList<>(); // AS = O(n)
//        helper(arr, taken, ans, v);
//        return ans;
//    }
//    private static void helper(int[] arr, boolean[] taken, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> v){
//        if(v.size() == arr.length){
//            ArrayList<Integer> copy = new ArrayList<>(v);
//            ans.add(copy);
//            return;
//        }
//        for(int i = 0; i< arr.length; i++){
//            if(!taken[i]) { // call lagega
//                v.add(arr[i]);
//                taken[i] = true;
//                helper(arr, taken, ans, v);
//                v.removeLast();
//                taken[i] = false;
//            }
//        }
//    }
}
