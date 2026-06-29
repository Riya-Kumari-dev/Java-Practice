package dsa.collections.priorityqueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SortByIncreasingFrequency {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements for the given array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(arr)+" on sorting in context of increasing frequency becomes "+Arrays.toString(frequencySort(arr)));
    }

    static class Pair implements Comparable<Pair>{
        int freq;
        int ele;
        Pair(int freq, int ele){
            this.freq = freq;
            this.ele = ele;
        }
        public int compareTo(Pair p){
            if(this.freq == p.freq) return Integer.compare(p.ele, this.ele); //decreasing we want
            return Integer.compare(this.freq, p.freq);
        }
    }
    // TC = O(n*log(n)), AS = O(n)
    private static int[] frequencySort(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : arr){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // minHeap
        for(int ele : map.keySet()){
            int freq = map.get(ele);
            pq.add(new Pair(freq, ele));
        }
        int[] ans = new int[arr.length];
        int idx = 0;
        while(!pq.isEmpty()){
            Pair top = pq.remove();
            int x = top.ele;
            for(int i=0; i<top.freq; i++){
                ans[idx++] = x;
            }
        }
        return ans;
    }
}