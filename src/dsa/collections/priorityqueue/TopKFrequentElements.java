package dsa.collections.priorityqueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TopKFrequentElements {
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

        System.out.println("Top " + k + " frequent elements in " + Arrays.toString(arr) + " are " + Arrays.toString(topKFreq(arr, k)));
    }

    static class Pair implements Comparable<Pair>{
        int freq;
        int ele;
        Pair(int freq, int ele){
            this.freq = freq;
            this.ele = ele;
        }
        public int compareTo(Pair p){
            return Integer.compare(this.freq, p.freq);
        }
    }
    // TC = O(n*log(k)) , AS = O(n)
    private static int[] topKFreq(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : arr){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // minHeap
        for(int ele : map.keySet()){
            int freq = map.get(ele);
            pq.add(new Pair(freq, ele));
            if(pq.size() > k) pq.remove();
        }
        int[] ans = new int[k];
        int idx = 0;
        while(!pq.isEmpty()){
            Pair top = pq.remove();
            int x = top.ele;
            ans[idx] = x;
            idx++;
        }
        return ans;
    }
}