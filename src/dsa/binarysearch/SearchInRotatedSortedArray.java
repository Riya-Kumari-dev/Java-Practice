package dsa.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class SearchInRotatedSortedArray {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the target : ");
        int target = sc.nextInt();

        int idx = search(arr, target);
        if(idx == -1) System.out.println(target+" is not present in "+ Arrays.toString(arr));
        else System.out.println(target+" is present at index "+idx+" in "+Arrays.toString(arr));
    }

    // arr is sorted in ascending order
    // prior to being passed to your function , arr is possibly rotated

    private static int search(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length-1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] <= arr[hi]) { // we are on the right side
                if(arr[mid] < target && arr[hi] >= target) lo = mid+1;
                else hi = mid-1;
            }
            else{ // we are on left side
                if(arr[mid] > target && arr[lo] <= target) hi = mid-1;
                else lo = mid+1;
            }
        }
        return -1;
    }

//    private static int search(int[] arr, int target) {
//        if(arr.length<=2){
//            for(int i=0; i<arr.length; i++){
//                if(arr[i] == target) {
//                    return i;
//                }
//            }
//            return -1;
//        }
//        // first we have to find the pivot index , from where the rotation starts
//        int lo = 1;
//        int hi = arr.length-2;
//        int pivot = -1;
//        while(lo <= hi){
//            int mid = lo + (hi-lo)/2;
//            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
//                pivot = mid;
//                break;
//            }
//            else if(arr[mid] < arr[mid-1] && arr[mid] < arr[mid+1]){
//                pivot = mid-1;
//                break;
//            }
//            else if(arr[mid] > arr[mid-1] && arr[mid] < arr[mid+1]) {
//                if(arr[mid] > arr[arr.length-1]) lo = mid+1;
//                else hi = mid-1;
//            }
//        }
//        if(pivot == -1) return binarySearch(arr, 0, arr.length-1, target);
//        // binary search in (0, pivot) and (pivot+1, n-1)
//        int left = binarySearch(arr, 0, pivot, target);
//        if(left != -1) return left;
//        return binarySearch(arr, pivot+1, arr.length-1, target);
//    }
//    private static int binarySearch(int[] arr, int lo, int hi, int target) {
//        while (lo <= hi) {
//            int mid = lo + (hi - lo) / 2;
//            if (arr[mid] == target) return mid;
//            else if (arr[mid] > target) hi = mid - 1; // go left
//            else lo = mid + 1; // arr[mid] < target => go right
//        }
//        return -1;
//    }
}