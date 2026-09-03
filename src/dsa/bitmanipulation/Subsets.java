package dsa.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Subsets {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the given array : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Subsets of "+ Arrays.toString(arr)+" are "+subsets(arr));
    }

    private static List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int total = (1 << arr.length);
        for(int num=0; num<total; num++){
            List<Integer> v = new ArrayList<>();
            for(int bitIdx = 0; bitIdx < arr.length; bitIdx++){
                if((num>>bitIdx) % 2 != 0) v.add(arr[bitIdx]);
            }
            ans.add(v);
        }
        return ans;
    }
}