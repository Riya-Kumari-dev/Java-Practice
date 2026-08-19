package collections;

import java.util.Vector;

public class VectorDemo {
    /* Vector :
    -> Legacy class from Java's collection framework that implements List.
    -> Behaves similar to ArrayList because it uses a dynamic/resizable array internally.
    -> Maintains insertion order.
    -> Allows duplicates.
    -> Allows null.
    -> Supports index-based access.
    -> Is synchronized.
    * */
    static void main(String[] args) {
        Vector v = new Vector(); // if no capacity specified , default capacity is 10
        System.out.println(v.capacity()); // 10
        v.add(10);
        v.add(30);
        v.add(34);
        v.add(30);
        v.add(45);

        System.out.println(v);

        // vector's growth depends on its capacity increment.
        Vector v2 = new Vector(4, 3); // here 3 is the capacity increment
        // if capacity increment is specified, capacity can grow with the increment of the given capacity increment.
        // else vector's capacity doubles.
    }
}