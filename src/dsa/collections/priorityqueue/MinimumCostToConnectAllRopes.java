package dsa.collections.priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumCostToConnectAllRopes {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of total ropes : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the length of " + n + " ropes : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Minimum cost to connect all the ropes of lengths "+ Arrays.toString(arr)+" is "+minCostToConnectRopes(arr)+" Rs");
    }

    // Given an array, arr[] of rope lengths,
    // connect all ropes into a single rope with the minimum total cost.
    // The cost to connect two ropes is the sum of their lengths.

    // TC = (n*log(n)) , AS = O(n)
    private static int minCostToConnectRopes(int[] arr) {
        // taking the sum of two min length ropes and adding them will cost minimum
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // minHeap
        for(int ele : arr) pq.add(ele);
        int sum = 0;
        while(pq.size()>1){
            int first = pq.remove();
            int second = pq.remove();
            sum += (first+second);
            pq.add(first+second);
        }
        return sum;
    }
}