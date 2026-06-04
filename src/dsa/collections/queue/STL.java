package dsa.collections.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class STL {
    static void main(String[] args) {
        // interface Queue extends Collections
        Queue<Integer> q = new LinkedList<>();
        // insert
        q.add(20);
        q.add(39);
        q.add(20);
        q.add(40);
        // offer(item);
        q.offer(23);
        q.offer(43);
        System.out.println(q); // [20, 39, 20, 40, 23, 43]
        // remove
        // remove() => returns and remove the head of the queue
        q.remove();
        System.out.println(q.remove()); // 39
        // poll() => returns and remove the head of the queue
        System.out.println(q.poll()); // 20

        System.out.println(q); // [40, 23, 43]
        q.add(40);
        q.add(36);
        q.add(65);
        // peek
        // peek() // returns the head , and returns null if queue is empty
        System.out.println(q.peek()); // 40
        // element() // returns the head but throw NoSuchElement Exception if the queue is empty

        // contains() => true if the element is present otherwise false
        System.out.println(q.contains(32)); // false

        System.out.println(q); // [40, 23, 43, 40, 36, 65]

        // addAll();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(3); a.add(2);
        q.addAll(a);
        System.out.println(q); // [40, 23, 43, 40, 36, 65, 3, 2]
    }
}
