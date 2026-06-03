package dsa.collections.stacks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class SlidingWindowMaximum {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the size of the window : ");
        int k = sc.nextInt();
        System.out.println(Arrays.toString(arr));
        int[] ans = maxSlidingWindow(arr, k);
        System.out.println(Arrays.toString(ans));
    }
    // You are given an array of integers nums,
    // there is a sliding window of size k which is moving from the very left of the array to the very right.
    // You can only see the k numbers in the window. Each time the sliding window moves right by one position.
    //Return the max sliding window.


    private static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        // first find the next greater element's index of each element
        Stack<Integer> st = new Stack<>();
        int[] ngi = new int[n];
        ngi[n-1] = n;
        st.push(n-1);
        for(int i=n-2; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) st.pop();
            if(st.isEmpty()) ngi[i] = n;
            else ngi[i] = st.peek();
            st.push(i);
        }

        // because for last k-1 elements no sliding window of size k possible
        int[] ans = new int[n-k+1];

        int j=0;
        for(int i=0; i<n-k+1; i++){
            if(j>=i+k) j=i; // agar window se bahar nikal gya hai to hi fir se i pe lao otherwise rehne do as it is because j poore window ke hi next greater pe khada hoga
            int max = nums[i];
            while(j<i+k){ // j should be inside the window
                max = nums[j];
                j = ngi[j];
            }
            ans[i] = max;
        }
        return ans;
    }


    // TC = O(n*k) if increasing so not optimal
//    private static int[] maxSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//
//        // first find the next greater element's index of each element
//        Stack<Integer> st = new Stack<>();
//        int[] ngi = new int[n];
//        ngi[n-1] = n;
//        st.push(n-1);
//        for(int i=n-2; i>=0; i--){
//            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) st.pop();
//            if(st.isEmpty()) ngi[i] = n;
//            else ngi[i] = st.peek();
//            st.push(i);
//        }
//
//        // because for last k-1 elements no sliding window of size k possible
//        int[] ans = new int[n-k+1];
//
//        for(int i=0; i<n-k+1; i++){
//            int j = i;
//            int max = nums[i];
//            while(j<i+k){ // j should be inside the window
//                max = nums[j];
//                j = ngi[j];
//            }
//            ans[i] = max;
//        }
//        return ans;
//    }
    // O(k*(n-k+1))
//    private static int[] maxSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//        // because for last k-1 elements no sliding window of size k possible
//        int[] ans = new int[n-k+1];
//        int idx = 0;
//        for(int i=0; i<n-k+1; i++){
//            int max = nums[i];
//            for(int j=i; j<i+k; j++){
//                max = Math.max(nums[j], max);
//            }
//            ans[idx++] = max;
//        }
//        return ans;
//    }

}
