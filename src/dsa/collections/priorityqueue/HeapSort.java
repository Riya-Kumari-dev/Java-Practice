package dsa.collections.priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HeapSort {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the given array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(heapSort(arr)));
    }

    // TC = O(n*log(n)) , AS = O(n)
    private static int[] heapSort(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // minHeap
        for(int ele : arr) pq.add(ele);

        int idx = 0;
        while(!pq.isEmpty()) arr[idx++] = pq.remove();

        return arr;
    }
}