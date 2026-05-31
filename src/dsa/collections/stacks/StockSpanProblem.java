package dsa.collections.stacks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class StockSpanProblem {
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
        int[] span = calculateSpan(arr);
        System.out.println(Arrays.toString(span));
    }

    //You are given an array arr[] representing daily stock prices,
    // the stock span for the i-th day is the number of consecutive days up to day i (including day i itself)
    // for which the price of the stock is less than or equal to the price on day i.
    // Return the span of stock prices for each day in the given sequence.
    private static int[] calculateSpan(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>(); // to store index
        int[] ans = new int[n];
        ans[0] = 1;
        st.push(0);
        for(int i=1; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            if(st.isEmpty()) ans[i] = i-(-1);
            else ans[i] = i-st.peek();
            st.push(i);
        }
        return ans;
    }
}