package dsa.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class KClosestElements {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter x: ");
        int x = sc.nextInt();
        System.out.print("Enter k : ");
        int k = sc.nextInt();

        System.out.println(k+" closest elements to "+x+" in "+ Arrays.toString(arr)+" are "+findClosestElements(arr, x, k));
    }

    private static ArrayList<Integer> findClosestElements(int[] arr, int x, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        if(x < arr[0]){
            for(int i=0; i<k; i++){
                ans.add(arr[i]);
            }
            return ans;
        }
        if(x > arr[n-1]){
            for(int i=n-1; i>=n-k; i--){
                ans.add(arr[i]);
            }
            Collections.sort(ans);
            return ans;
        }
        // find the lower bound of x
        int lo = 0;
        int hi = n-1;
        int lb = n;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid] >= x) {
                lb = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }
        // two pointer approach
        int i=lb-1;
        int j=lb;
        while(k>0 && i>=0 && j<n){
            int iDis = Math.abs(x-arr[i]);
            int jDis = Math.abs(x-arr[j]);
            if(iDis <= jDis) ans.add(arr[i--]);
            else ans.add(arr[j++]);
            k--;
        }
        while(i<0 && k>0) {
            ans.add(arr[j++]);
            k--;
        }
        while(j>=n && k>0) {
            ans.add(arr[i--]);
            k--;
        }
        Collections.sort(ans);
        return ans;
    }
}