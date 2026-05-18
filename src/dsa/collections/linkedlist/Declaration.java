package dsa.collections.linkedlist;

import java.util.LinkedList;

public class Declaration {
    static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add(19);
        ll.add(39);
        ll.add("Java");
        ll.add(5.4);
        ll.add(70);
        ll.add("Riya");
        System.out.println(ll); // [19, 39, Java, 5.4, 70, Riya]
        ll.addFirst(4);
        ll.addLast(56);
        System.out.println(ll); // [4, 19, 39, Java, 5.4, 70, Riya, 56]
        ll.offer(45);
        System.out.println(ll); // [4, 19, 39, Java, 5.4, 70, Riya, 56, 45]
        System.out.println(ll.peek()); // returns the first element // 4
        System.out.println(ll.poll()); // returns the first element and remove from the list // 4
        System.out.println(ll); // [19, 39, Java, 5.4, 70, Riya, 56, 45]
    }
}
