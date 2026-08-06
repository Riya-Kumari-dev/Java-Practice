package collections;

import java.util.LinkedList;

public class LinkedListDemo {
    /* LinkedList :
    -> It implements both List and Deque.
    -> Maintains insertion order.
    -> Allows duplicates and null values.
    -> Dynamic size.
    -> Doubly linked list internally.
    -> More memory overhead than ArrayList because each node stores links.
    */
    static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // add :
        // add(), addFirst() and addLast() costs O(1) because LinkedList maintains reference to the first and last node.
        ll.add(20);
        ll.add(30);
        ll.addFirst(10);
        ll.addLast(40);

        ll.offer("Riya");
        ll.offerFirst("Gupta");
        System.out.println(ll); // [Gupta, 10, 20, 30, 40, Riya]

        // get(index)
        // Java's LinkedList can traverse from whichever end is closer but worst case remains O(n)
        System.out.println(ll.get(2)); // 20

        // set(idx, value)
        // O(n)
        ll.set(2, 45);

        // remove()
        ll.remove(2); // O(n)
        System.out.println(ll.remove()); // Gupta -> O(1) removes the first element
        System.out.println(ll.poll()); // 10 -> O(1) removes the first element

        // peek() -> O(1)
        System.out.println(ll.peek()); // 30
        System.out.println(ll.peekFirst()); // 30
        System.out.println(ll.peekLast()); // Riya
    }
}