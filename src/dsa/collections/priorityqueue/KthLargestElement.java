package dsa.collections.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestElement {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the given array : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter k : ");
        int k = sc.nextInt();
        System.out.println(k+"th largest element is "+kthSmallestElement(arr, k));
    }

    // using minHeap
    // TC = O(n*log(k+1)) , SC = O(k+1)
    private static int kthSmallestElement(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // O(n*log(k+1)
        for(int ele : arr) { // add O(n*log(k+1)), remove O((n-k)*log(k+1))
            pq.add(ele); // O(log(k+1))
            if (pq.size() > k) pq.remove(); // O(log(k+1))
        }
        return pq.peek();
    }
}