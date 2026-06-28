package dsa.collections.priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SortANearlySortedArray {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the given array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter k : ");
        int k = sc.nextInt();

        System.out.println(Arrays.toString(arr));
        arr = sort(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    // the elements are present at most k distance from its actual position
    private static int[] sort(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int idx = 0;
        for(int ele : arr){
            pq.add(ele);
            if(pq.size()>k) arr[idx++] = pq.remove(); // the min element will be at the current index
        }
        // for remaining elements
        while(!pq.isEmpty()) arr[idx++] = pq.remove();
        return arr;
    }
}