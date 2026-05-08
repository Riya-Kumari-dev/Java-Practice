package dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwoSum {
    static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n]; // empty array of size 4;
        System.out.print("Enter the elements of the array : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the target : ");
        int target = sc.nextInt();
        print(arr);
        System.out.println("Target = "+target);
        ArrayList<Integer> ans = twoSum(arr, target);
        if(ans.size() == 0) System.out.println("No such elements are present whose sum equal to " + target+" having different indices.");
        else System.out.println("Elements are "+ans);
    }

    private static ArrayList<Integer> twoSum(int[] arr, int target) {
        Arrays.sort(arr); // built in sort => TC = O(nlogn)
        int n = arr.length;
        int i=0;
        int j=n-1;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i<j){
            if(arr[i] + arr[j] == target) {
                ans.add(arr[i]);
                ans.add(arr[j]);
                break;
            }
            else if(arr[i] + arr[j] > target){
                j--;
            }
            else i++;
        }
        return ans;
    }

    private static void print(int[] arr){
        for(int ele : arr){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
}
