package dsa.collections.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class UniqueNumberOfOccurrences {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the array : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        if(uniqueOccurrences(arr)) System.out.println(Arrays.toString(arr) +" has unique number of occurrences for each element.");
        else System.out.println(Arrays.toString(arr) +" has not unique number of occurrences for each element.");

    }

    private static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : arr) map.put(ele, map.getOrDefault(ele,0)+1);

        HashSet<Integer> set = new HashSet<>();
        for(int value : map.values()) set.add(value);

        return set.size() == map.size();
    }
}