package dsa.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class FirstAndLastPosition {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter a target to be searched : ");
        int target = sc.nextInt();

        int[] ans = searchRange(arr, target);
        if(ans[0] == -1 && ans[1] == -1) System.out.println(target+" is not present in "+ Arrays.toString(arr));
        else System.out.println("First and last occurrence of "+target+" in "+Arrays.toString(arr)+" are "+Arrays.toString(ans)+" respectively.");
    }

    private static int[] searchRange(int[] arr, int target) {
        // first occurrence
        int lo = 0;
        int hi = arr.length-1;
        int first = -1;
        while(lo <= hi){
            int mid = lo +(hi-lo)/2;
            if(arr[mid] == target){
                if(mid-1 >= 0 && arr[mid-1] == target){ // then mid is not the first occurrence => reduce the search space
                    hi = mid-1;
                }
                else { // mid is the first occurrence
                    first = mid;
                    break;
                }
            }
            else if(arr[mid] > target) hi = mid-1; // go left
            else lo = mid + 1; // arr[mid] < target => go right
        }

        // last occurrence
        lo = 0;
        hi = arr.length-1;
        int last = -1;
        while(lo <= hi){
            int mid = lo +(hi-lo)/2;
            if(arr[mid] == target){
                if(mid+1 < arr.length && arr[mid+1] == target){ // then mid is not the last occurrence => reduce the search space
                    lo = mid+1;
                }
                else { // mid is the last occurrence
                    last = mid;
                    break;
                }
            }
            else if(arr[mid] > target) hi = mid-1; // go left
            else lo = mid + 1; // arr[mid] < target => go right
        }
        return new int[]{first, last};
    }

//    private static int[] searchRange(int[] arr, int target) {
//        int[] ans = {-1,-1};
//        // first let's find out the target is present or not
//        // using normal binary search
//        int lo = 0;
//        int hi = arr.length-1;
//        boolean flag = false;
//        while(lo <= hi){
//            int mid = lo +(hi-lo)/2;
//            if(arr[mid] == target){
//                flag = true;
//                break;
//            }
//            else if(arr[mid] > target) hi = mid-1; // go left
//            else lo = mid + 1; // arr[mid] < target => go right
//        }
//        if(!flag) return ans;
//
//        // now it is clear that the target is present
//        // first occurrence = lower bound of the target
//        lo = 0;
//        hi = arr.length-1;
//        int lb = arr.length;
//        while(lo <= hi){
//            int mid = lo + (hi-lo)/2;
//            if(arr[mid] >= target) {
//                lb = Math.min(lb, mid);
//                hi = mid-1;
//            }
//            else lo = mid+1;
//        }
//        ans[0] = lb;
//
//        // last occurrence = upper bound of the target - 1
//        lo = 0;
//        hi = arr.length-1;
//        int ub = arr.length;
//        while(lo <= hi){
//            int mid = lo + (hi-lo)/2;
//            if(arr[mid] > target) {
//                ub = Math.min(ub, mid);
//                hi = mid-1;
//            }
//            else lo = mid+1;
//        }
//        ans[1] = ub-1;
//        return ans;
//    }
}