package dsa.collections.stacks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement2 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        int[] ans = nextGreaterElement(arr);
        System.out.println(Arrays.toString(ans));
    }

    // Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]),
    // return the next greater number for every element in nums.
    private static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--) st.push(arr[i]);
        int[] ans = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && st.peek() <= arr[i]) st.pop();
            if(st.isEmpty()) ans[i] = -1;
            else ans[i] = st.peek();
            st.push(arr[i]);
        }
        return ans;
    }
}