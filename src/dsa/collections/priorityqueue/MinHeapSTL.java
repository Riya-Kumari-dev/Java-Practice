package dsa.collections.priorityqueue;

import java.util.PriorityQueue;

public class MinHeapSTL {
    static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // every time performing add and remove TC = O(log(n)) (rearranging them) where n is the number of elements currently present in the priority queue
        // add
        pq.add(20); pq.add(10); pq.add(40); pq.add(20); pq.add(53);
        pq.offer(35); pq.offer(10);

        System.out.println(pq.peek()); // returns the smallest value element => 10

        // smallest element at the top
        System.out.println(pq); // [10, 20, 10, 20, 53, 40, 35]

        // remove
        pq.remove(); // removes the smallest element i.e., 10
        System.out.println(pq); // [10, 20, 35, 20, 53, 40]

        pq.remove(35); // removes the specified object

        System.out.println(pq.poll()); // returns and remove the smallest element => 10
        System.out.println(pq.remove()); // // returns and remove the smallest element => 20
        System.out.println(pq); // [20, 40, 53]
    }
}