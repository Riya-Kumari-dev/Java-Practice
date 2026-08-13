package collections;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
    /* LinkedHashSet :
    -> It is a subclass of HashSet and implements Set.
    -> Unique elements + maintains insertion order.
    -> Backed by a LinkedHashMap. Conceptually it combines Hash table + doubly linked list.
    -> The hash table provides efficient lookup. The doubly linked list maintains the insertion order.
    -> O(1) average.
    * */
    static void main(String[] args) {
        LinkedHashSet ls = new LinkedHashSet();

        ls.add(10);
        ls.add(20);
        ls.add(30);
        ls.add(40);

        System.out.println(ls); // [10, 20, 30, 40]
        ls.remove(30);
        System.out.println(ls); // [10, 20, 40]
        ls.add(30);
        System.out.println(ls); // [10, 20, 40, 30]
    }
}
