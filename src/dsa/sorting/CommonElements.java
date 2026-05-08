package dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CommonElements {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the first array : ");
        int m = sc.nextInt();
        int[] arr1 = new int[m];
        System.out.print("Enter " + m + " elements for the array : ");
        for (int i = 0; i < m; i++) {
            arr1[i] = sc.nextInt();
        }
        System.out.print("Enter the size of the second array : ");
        int n = sc.nextInt();
        int[] arr2 = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        print(arr1);
        print(arr2);
        ArrayList<Integer> ans = commonElements(arr1, arr2);
        System.out.println("Common Elements present in both the arrays are : "+ans);
    }

    private static ArrayList<Integer> commonElements(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i=0;
        int j=0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i<a.length && j<b.length){
            if(a[i] == b[j]) {
                ans.add(a[i]);
                i++;
                j++;
            }
            else if(a[i] < b[j]) i++;
            else j++;
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