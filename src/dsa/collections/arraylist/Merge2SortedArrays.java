package dsa.collections.arraylist;

import java.util.ArrayList;

public class Merge2SortedArrays {
    static void main(String[] args) {
        int[] arr = {2,5,6,9};
        int[] brr = {1,3,4,5,7,8};
        print(arr);
        print(brr);
        //int[] ans = new int[arr.length+brr.length];
        ArrayList<Integer> ans = Merge(arr, brr);
        System.out.println(ans);
    }
    static void print(int[] arr){
        for(int ele : arr){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
    static ArrayList<Integer> Merge(int[] arr, int[] brr){
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0;
        int j=0;
        int n = arr.length;
        int m = brr.length;
        while(i<n && j<m){
            if(arr[i] < brr[j]){
                ans.add(arr[i]);
                i++;
            }
            else{
                ans.add(brr[j]);
                j++;
            }
        }
        while(i<n){
            ans.add(arr[i]);
            i++;
        }
        while(j<m){
            ans.add(brr[j]);
            j++;
        }
        return ans;
    }
}
