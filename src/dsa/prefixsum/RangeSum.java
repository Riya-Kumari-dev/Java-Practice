package dsa.prefixsum;

import java.util.Arrays;

public class RangeSum {
    int[] arr;

    // Overall TC for one query = O(n)
    // TC for q queries = O(n)

    // TC = O(n)
    public RangeSum(int[] nums){ // only one time it is called
        arr = Arrays.copyOf(nums, nums.length);
        // make arr prefix sum array
        for(int i=1; i<arr.length; i++){
            arr[i] += arr[i-1];
        }
    }
    // TC = O(1)
    public int sumRange(int left, int right) { // queries are related to this only.
        if(left == 0) return arr[right];
        return arr[right] - arr[left-1];
    }

    // Brute force
//    public RangeSum(int[] nums) {
//        arr = Arrays.copyOf(nums, nums.length);
//    }
    // TC = for one query = O(n);
//    // TC for q query = O(n*q);
//    public int sumRange(int left, int right) {
//        int sum = 0;
//        for(int i=left; i<= right; i++){
//            sum += arr[i];
//        }
//        return sum;
//    }
}
