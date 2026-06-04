package dsa.collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class OperationsAtParticularIndex {
    static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10); q.add(20); q.add(30); q.add(40);
        System.out.println(q); // [10, 20, 30, 40]
        add(2,65,q);
        System.out.println(q); // [10, 20, 65, 30, 40]
        remove(3, q);
        System.out.println(q); // [10, 20, 65, 40]
        add(1,23, q);
        System.out.println(q); // [10, 23, 20, 65, 40]
        System.out.println(peek(4, q)); // 40
        System.out.println(q); // [10, 23, 20, 65, 40]

    }

    private static int peek(int idx, Queue<Integer> q) {
        int n = q.size();
        // first remove and add the first idx elements
        for(int i=0; i<idx; i++){
            q.add(q.remove());
        }
        // mark the idxth position element
        int ele = q.peek();
        // now remove and add n-idx elements
        for(int i=0; i<n-idx; i++){
            q.add(q.remove());
        }
        return ele;
    }

    private static void remove(int idx, Queue<Integer> q) {
        int n = q.size();
        // first remove and add the first idx elements
        for(int i=0; i<idx; i++){
            q.add(q.remove());
        }
        // remove the idxth element
        q.remove();
        // now remove and add the current size - idx elements
        for(int i=0; i<q.size()-idx; i++){
            q.add(q.remove());
        }
    }

    private static void add(int idx, int val, Queue<Integer> q) {
        int n = q.size();
        // first remove and add the first idx elements
        for(int i=0; i<idx; i++){
            q.add(q.remove());
        }
        // add the val at required i.e. idxth position
        q.add(val);
        // now remove and add n-idx  elements
        for(int i=0; i<n-idx; i++){
            q.add(q.remove());
        }
    }
}