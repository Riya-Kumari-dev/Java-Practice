package dsa.collections.priorityqueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthSmallestElement {
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
        System.out.println(k+"th smallest element is "+kthSmallestElement(arr, k));
    }

    // using maxHeap
    // TC = O(n*log(k+1)) , SC = O(k+1)
    private static int kthSmallestElement(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // O(n*log(k+1)
        for(int ele : arr) { // add O(n*log(k+1)), remove O((n-k)*log(k+1))
            pq.add(ele); // O(log(k+1))
            if (pq.size() > k) pq.remove(); // O(log(k+1))
        }
        return pq.peek();
    }

    // using minHeap
    // TC = (n*log(n)) , SC = O(n)
//    private static int kthSmallestElement(int[] arr, int k) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for(int ele : arr){ // O(n*log(n))
//            pq.add(ele); // O(log(n))
//        }
//        // remove k-1 elements  => TC = O((k-1)*log(n))
//        for(int i=1; i<k; i++){
//            pq.remove();
//        }
//        return pq.peek();
//    }


    // using selection sort
    // TC = O(k*n), SC = O(1)
//    private static int kthSmallestElement(int[] arr, int k) {
//        for(int i=0; i<k; i++){ // O(k)
//            int mni = i;
//            for(int j=i; j<arr.length; j++){ // O(n)
//                if(arr[j] < arr[mni]) mni = j;
//            }
//            // swap the smallest element with first element
//            int temp = arr[i];
//            arr[i] = arr[mni];
//            arr[mni] = temp;
//        }
//        return arr[k-1];
//    }

    // brute force
    // TC = O(nlog(n)), SC = O(log(n)) => quick sort used
//    private static int kthSmallestElement(int[] arr, int k) {
//        Arrays.sort(arr);
//        return arr[k-1];
//    }
}