package collections;

import java.util.ArrayList;

public class ArrayListDemo {
    /* ArrayList :
    -> It is a resizable array implementation of List interface.
    -> Provides index based access.
    -> Not synchronized by default.
    -> Internally uses a dynamic array (Object[])
    */
    static void main(String[] args) {
        ArrayList al = new ArrayList();
        // ArrayList stores reference to objects in the backing array.

        /*add(Object e)
        * -> O(1) amortized.
        * -> When the backing array becomes full, elements are copied into the new array. Therefore, a resize operation costs O(n).
        * -> But resizing happens occasionally, so adding at the end is O(1) amortized.*/
        al.add(20);
        al.add("Nitya");
        al.add(2.5);
        al.add(true);

        System.out.println(al); // [20, Nitya, 2.5, true]

        System.out.println(al.get(2)); // Nitya -> O(1)
        ArrayList al2 = new ArrayList();
        al2.add(30);
        al2.add(0, 34); // add(idx, ele) -> elements must shift right -> O(n)
        al.add(al2);
        System.out.println(al); // [20, Nitya, 2.5, true, [34, 30]]

        // remove(index)
        System.out.println(al.remove(2.3)); // false
        al.remove(2); // elements must shift left -> O(n)
        al.removeFirst();
        al.removeLast();
        System.out.println(al); // [Nitya, true]
    }
}