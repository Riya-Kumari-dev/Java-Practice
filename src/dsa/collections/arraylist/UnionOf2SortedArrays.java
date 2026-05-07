package dsa.collections.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class UnionOf2SortedArrays {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the first array : ");
        int m = sc.nextInt();
        int[] arr1 = new int[m];
        System.out.print("Enter " + m + " elements for the array (sorted) : ");
        for (int i = 0; i < m; i++) {
            arr1[i] = sc.nextInt();
        }
        System.out.print("Enter the size of the second array : ");
        int n = sc.nextInt();
        int[] arr2 = new int[n];
        System.out.print("Enter " + n + " elements for the array (sorted): ");
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        print(arr1);
        print(arr2);
        ArrayList<Integer> ans = findUnion(arr1, arr2);
        System.out.println("Union of both arrays : "+ans);
    }

    private static ArrayList<Integer> findUnion(int[] a, int[] b) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<a.length && j<b.length){

            if(a[i] < b[j]){
                if(ans.isEmpty() || ans.getLast() != a[i])  ans.add(a[i]);
                i++;
            }
            else if(a[i]>b[j]) {
                if(ans.isEmpty() || ans.getLast() != b[j]) ans.add(b[j]);
                j++;
            }
            else {
                if(ans.isEmpty() || ans.getLast() != a[i]) ans.add(a[i]);
                i++;
                j++;
            }
        }
        while(i<a.length){
            if(ans.isEmpty() || ans.getLast() != a[i])   ans.add(a[i]);
            i++;
        }
        while(j==0 || j<b.length){
            if(ans.isEmpty() || ans.getLast() != b[j]) ans.add(b[j]);
            j++;
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
