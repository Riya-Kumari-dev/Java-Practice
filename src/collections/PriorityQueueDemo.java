package collections;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    /* Priority Queue :
    -> A Java class that implements the Queue interface.
    -> The element with the highest priority is removed first.
    -> It internally uses a heap. By default, it is a Min-Heap.

    * */
    static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(); // by default, it is a minHeap
        PriorityQueue pq2 = new PriorityQueue(Collections.reverseOrder()); // maxHeap

        // add() / offer()
        // -> The new element is first inserted at the next available position to maintain the binary tree. Then we perform heapify up / sift up.
        // -> O(log(n))
        pq.add(10);
        pq.add(20);
        pq.add(40);
        pq.add(5);
        pq.add(-4);
        pq.offer(4);

        pq2.add(10);
        pq2.add(20);
        pq2.add(40);
        pq2.add(5);
        pq2.add(-4);
        pq2.offer(4);

        // A heap is not a fully sorted structure
        System.out.println(pq); // [-4, 5, 4, 20, 10, 40]
        System.out.println(pq2); // [40, 10, 20, 5, -4, 4]

        // peek()
        // -> returns the highest priority element without removing it.
        // TC = O(1) Because the highest priority element is at the root.
        System.out.println(pq.peek()); // -4
        System.out.println(pq2.peek()); // 40

        // poll()
        // Returns and removes the highest priority element.
        // TC = O(log(n)) -> Because after removing the root, the heap needs to be restored using heapify down/ sift down.
        System.out.println(pq.poll()); // -4
        System.out.println(pq2.poll()); // 40

        // Heapify down :
        // -> The last element is moved to the root. Then compare its children and swap with the smallest child until the heap property is restored.
        // -> Since the element can move down at most the height of the heap : O(log(n))

        System.out.println(pq); // [4, 5, 40, 20, 10]
        System.out.println(pq2); // [20, 10, 4, 5, -4]
    }
}