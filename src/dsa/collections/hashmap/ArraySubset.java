package dsa.collections.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ArraySubset {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the first array : ");
        int m = sc.nextInt();
        int[] a = new int[m];
        System.out.print("Enter " + m + " elements for the given array : ");
        for(int i=0; i<m; i++){
            a[i] = sc.nextInt();
        }
        System.out.print("Enter the size of the second array : ");
        int n = sc.nextInt();
        int[] b = new int[n];
        System.out.print("Enter " + n + " elements for the given array : ");
        for(int i=0; i<n; i++){
            b[i] = sc.nextInt();
        }
        if(isSubset(a, b)) System.out.println("Yes, "+ Arrays.toString(b)+" is a subset of "+Arrays.toString(a));
        else System.out.println("No, "+ Arrays.toString(b)+" is not a subset of "+Arrays.toString(a));
    }

    private static boolean isSubset(int[] a, int[] b) {
        HashMap<Integer,Integer> m = new HashMap<>();
        // add the elements of a in map
        for(int ele : a){
            m.put(ele, m.getOrDefault(ele, 0)+1);
        }
        // now iterate through second array
        for(int j : b) {
            if (!m.containsKey(j)) return false;
            else { // if found reduce the freq
                if (m.get(j) == 1) m.remove(j);
                else m.put(j, m.get(j) - 1);
            }
        }
        return true;
    }
}