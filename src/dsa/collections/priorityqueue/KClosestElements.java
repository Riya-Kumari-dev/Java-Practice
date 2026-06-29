package dsa.collections.priorityqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KClosestElements {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the given array : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter x : ");
        int x = sc.nextInt();
        System.out.print("Enter k : ");
        int k = sc.nextInt();

        System.out.println(findClosestElements(arr, k, x));
    }

    // Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
    // The result should also be sorted in ascending order.
    //An integer a is closer to x than an integer b if:
    //|a - x| < |b - x|, or
    //|a - x| == |b - x| and a < b
    static class Pair implements Comparable<Pair>{
        int dis;
        int x;
        Pair(int dis, int x){
            this.dis = dis;
            this.x = x;
        }
        public int compareTo(Pair p){
            if(this.dis == p.dis) return Integer.compare(this.x, p.x); // hame chhote ko pehle rakhna hai
            return Integer.compare(this.dis, p.dis);
        }
    }
    // TC = O(n*log(k)), AS = O(k)
    private static ArrayList<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder()); // maxHeap
        for (int ele : arr) { // TC = O(n*log(k))
            int dis = Math.abs(x - ele);
            Pair p = new Pair(dis, ele);
            pq.add(p);
            if (pq.size() > k) pq.remove();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){ // TC = O(k*log(k))
            Pair top = pq.remove();
            ans.add(top.x);
        }
        Collections.sort(ans); // TC = O(k*log(k))
        return ans;
    }
}