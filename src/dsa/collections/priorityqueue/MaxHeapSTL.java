package dsa.collections.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeapSTL {
    static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // every time performing add and remove TC = O(log(n)) (rearranging them) where n is the number of elements currently present in the priority queue
        // add
        pq.add(20); pq.add(10); pq.add(40); pq.add(20); pq.add(53);
        pq.offer(35); pq.offer(10);

        System.out.println(pq.peek()); // returns the largest value element => 53

        // largest element at the top
        System.out.println(pq); // [53, 40, 35, 10, 20, 20, 10]

        // remove
        pq.remove(); // removes the largest element i.e., 10
        System.out.println(pq); // [40, 20, 35, 10, 10, 20]

        pq.remove(35); // removes the specified object

        System.out.println(pq.poll()); // returns and remove the largest element => 40
        System.out.println(pq.remove()); // // returns and remove the largest element => 20
        System.out.println(pq); // [20, 10, 10]
    }
}