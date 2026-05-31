package dsa.collections.stacks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NumberOfVisiblePeopleInAQueue{
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of persons standing in queue : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter heights of "+n+" persons : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        int[] ans = canSeePersonsCount(arr);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] canSeePersonsCount(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        st.push(arr[n-1]);
        ans[n-1] = 0;
        for(int i=n-2; i>=0; i--){
            int count = 0;
            while(!st.isEmpty() && st.peek() <= arr[i]) { // apne se barabar aur chhoto ko dekhega hi
                count++;
                st.pop();
            }
            if(!st.isEmpty()) count++; // st.peek() is the next greater element of arr[i] => usko bhi dekh sakta hai
            ans[i] = count;
            st.push(arr[i]);
        }
        return ans;
    }
}