package dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FindAllNumbersDisappearedInArray {
    static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements of the array (in range 1 to n) : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> ans = findDisappearedNumbers(arr);
        System.out.println("Elements disappeared from "+ Arrays.toString(arr)+" are "+ans);
    }
    private static ArrayList<Integer> findDisappearedNumbers(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0;
        while(i < arr.length){
            int correctIdx = arr[i]-1;
            if(arr[i] != arr[correctIdx]) {
                int temp = arr[i];
                arr[i] = arr[correctIdx];
                arr[correctIdx] = temp;
            }
            else{
                i++;
            }
        }
        for(i=0; i< arr.length; i++){
            if(arr[i] != i+1) ans.add(i+1);
        }
        return ans;
    }
}