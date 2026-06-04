package dsa.collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Traversal {
    static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(20);
        q.add(39);
        q.add(20);
        q.add(40);

        display(q);
    }

    public static void display(Queue<Integer> q) {
        int n = q.size();
        System.out.print("[");
        for(int i=0; i<n; i++){
            System.out.print(q.peek());
            if(i!=n-1) System.out.print(",");
            q.add(q.remove());
        }
        System.out.println("]");
    }
}