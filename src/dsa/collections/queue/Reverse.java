package dsa.collections.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Reverse {
    static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10); q.add(20);
        q.add(30); q.add(40);
        q.add(50);
        System.out.println(q);
        reverse(q);
        System.out.println(q);
    }

    private static void reverse(Queue<Integer> q) {
        Stack<Integer> st = new Stack<>();
        while(!q.isEmpty()){
            st.push(q.remove());
        }
        while(!st.isEmpty()) q.add(st.pop());
    }
}