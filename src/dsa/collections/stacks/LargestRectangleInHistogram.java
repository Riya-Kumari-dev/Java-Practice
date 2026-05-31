package dsa.collections.stacks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class LargestRectangleInHistogram {
    static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the bars of histogram : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " lengths for the histogram's bars : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        int ans = largestRectangleArea(arr);
        System.out.println("Largest Rectangle that can be formed is "+ans);
    }
    // Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
    // return the area of the largest rectangle in the histogram.

    public static int largestRectangleArea(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        // find the next smaller element's index of each element
        int[] nsi = new int[n];
        nsi[n-1] = n;
        st.push(n-1);
        for(int i=n-2; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()]>= arr[i]) st.pop();
            if(st.isEmpty()) nsi[i] = n;
            else nsi[i] = st.peek();
            st.push(i);
        }
        st.clear();
        // find the previous smaller element's index of each element
        int[] psi = new int[n];
        psi[0] = -1;
        st.push(arr[0]);
        for(int i=1; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            if(st.isEmpty()) psi[i] = -1;
            else psi[i] = st.peek();
            st.push(i);
        }

        // find the  area of the largest rectangle formed
        // each rectangle would be length*(nsi-psi-1);
        int maxArea = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            maxArea = Math.max(maxArea, arr[i] * (nsi[i] - psi[i] -1));
        }
        return maxArea;
    }
}