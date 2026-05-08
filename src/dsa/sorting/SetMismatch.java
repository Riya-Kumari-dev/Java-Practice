package dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SetMismatch {
    static void main(String[] args) {
        // given an array due to some array an element is replaced with one of the already added element
        // your task is to find out the repeated and missed element from the array
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements of the array (1 to n) : ");
        // duplicates can occur only twice not more than 2 times
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Duplicate number in "+ Arrays.toString(arr)+" are "+duplicateAndMissingNumber(arr));
    }

    private static List<Integer> duplicateAndMissingNumber(int[] nums) {
        int i=0;
        List<Integer> ans = new ArrayList<>();
        while(i<nums.length){
            int correctIdx = nums[i]-1;
            if(nums[i] != nums[correctIdx]){
                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            }
            else i++; // at the right place => nums[i] == i+1
        }
        for(i=0; i<nums.length; i++){
            if(nums[i] != i+1) {
                ans.add(nums[i]);
                ans.add(i+1);
            }
        }
        return ans;
    }
}
