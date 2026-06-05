package dsa.collections.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RearrangeQueue {
    static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>(); // even size queue
        q.add(1); q.add(2);
        q.add(3); q.add(4);
        q.add(5); q.add(6);
        q.add(7); q.add(8);
        System.out.println(q);
        q = rearrangeQueue(q);
        System.out.println(q);
    }

    // using one stack
    private static Queue<Integer> rearrangeQueue(Queue<Integer> q) {
        int n = q.size();
        Stack<Integer> helper = new Stack<>();
        // n/2 elements from queue to stack
        for(int i=0; i<n/2; i++){
            helper.add(q.remove());
        }
        // n/2 elements from stack to queue
        while(!helper.isEmpty()) q.add(helper.pop());
        // n/2 elements from queue to stack
        for(int i=0; i<n/2; i++){
            helper.add(q.remove());
        }
        // alternate popping first from stack then queue
        while(!helper.isEmpty()){
            q.add(helper.pop());
            q.add(q.remove());
        } // will be in reverse fashion
        // wapas se stack me so it get what we want
        while(!q.isEmpty()){
            helper.push(q.remove());
        }
        while(!helper.isEmpty()) q.add(helper.pop());
        return q;
    }

    // using queue
//    private static Queue<Integer> rearrangeQueue(Queue<Integer> q) {
//        int n = q.size();
//        Queue<Integer> helper = new LinkedList<>();
//        for(int i=0; i<n/2; i++){
//            helper.add(q.remove());
//        }
//        n = q.size();
//        for(int i=0; i<n; i++){
//            q.add(helper.remove());
//            q.add(q.remove());
//        }
//        return q;
//    }
}