package dsa.collections.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ReverseFirstKElements {
    static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10); q.add(20);
        q.add(30); q.add(40);
        q.add(50);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter k : ");
        int k = sc.nextInt();
        System.out.println(q);
        reverseFirstK(q, k);
        System.out.println(q);
    }

    private static void reverseFirstK(Queue<Integer> q, int k) {
        Stack<Integer> st = new Stack<>();
        int n = q.size();
        for(int i=0; i<k; i++){
            st.push(q.remove());
        }
        while(!st.isEmpty()) q.add(st.pop());
        for(int i=0; i<n-k; i++){
            q.add(q.remove());
        }
    }
}
