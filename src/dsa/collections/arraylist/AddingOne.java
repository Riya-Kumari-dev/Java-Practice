package dsa.collections.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AddingOne {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
        ArrayList<Integer> ans  = AddOne(arr);
        for (int ele : ans) {
            System.out.print(ele + " ");
        }
    }

    private static ArrayList<Integer> AddOne(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n=arr.length;
        int carry = 1;
        for(int i=n-1; i>=0; i--){
            if(arr[i] == 9) {
                ans.add(0);
                carry = 1;
            }
            else{
                ans.add(carry + arr[i]);
                carry = 0;
            }
        }
        if(carry == 1) ans.add(1);
        Collections.reverse(ans);
        return ans;
    }

}
