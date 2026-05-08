package dsa.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class FirstMissingPositive {
    static void main(String[] args) {
        // Given an unsorted integer array nums. Return the smallest positive integer that is not present in arr
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements of the array : ");
        // duplicates can occur only twice not more than 2 times
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Duplicate number in "+ Arrays.toString(arr)+" is "+firstMissingPositive(arr));
    }

    private static int firstMissingPositive(int[] nums) {
        int i=0;
        while(i< nums.length){
            int correctIdx = nums[i]-1;
            if(nums[i]>0 && nums[i] <= nums.length  && nums[i] != nums[correctIdx]){
                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            }
            else i++;
        }
        for(i=0; i<nums.length; i++){
            if(nums[i] != i+1) return i+1;
        }
        return nums.length+1;
    }
}
