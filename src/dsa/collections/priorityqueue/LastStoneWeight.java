package dsa.collections.priorityqueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LastStoneWeight {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of total stones : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the weights of " + n + " stones : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Last stone left from "+ Arrays.toString(arr)+" weighs "+lastStoneWeight(arr)+"kg");
    }

    // stones[i] is the weight of the ith stone
    //We are playing a game with the stones. On each turn,
    // we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y.
    // The result of this smash is:
    //If x == y, both stones are destroyed, and
    //If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
    //At the end of the game, there is at most one stone left.
    //Return the weight of the last remaining stone. If there are no stones left, return 0.

    // TC = O(n*log(n)) , AS = O(n)
    private static int lastStoneWeight(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele : arr){
            pq.add(ele);
        }
        while(pq.size()>1){
            int a = pq.remove();
            int b = pq.remove();
            if(a!=b){
                pq.add(Math.abs(a-b));
            }
        }
        if(pq.isEmpty()) return 0;
        else return pq.peek();
    }
}