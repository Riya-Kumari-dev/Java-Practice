package collections;

import java.util.HashSet;

public class HashSetDemo {
    /* HashSet :
    -> Implements the Set interface.
    -> unique elements + fast operations + no guaranteed order.
    -> Backed by a HashMapDemo. The hash table allows efficient insertion, deletion and searching.
    -> We generally say O(1) average, not simply O(1) because collisions can affect performance.
    * */
    static void main(String[] args) {
        HashSet s = new HashSet();

        // add() -> O(1) average
        // hashcode() + equals()
        // hashcode() finds the possible bucket, and equals() checks whether an equal element already exists there
        s.add(10);
        s.add(20);
        s.add(40);
        s.add(30);
        /* Duplicates not allowed.
        -> If a duplicate object come, hashcode() finds the possible bucket, and equals() checks whether an equal element already exists there.
        -> if present then it is ignored.*/
        s.add(10);
        System.out.println(s); // [20, 40, 10, 30]

        /* Hash collision :
        -> Suppose two different objects produce the same hash code, they may therefore end up in the same bucket. This is called hash collision.
        -> But having the same hash code doesn't mean the objects are equal.
        * */

        s.remove(30);

        System.out.println(s.contains(30)); // false

        System.out.println(s); // [20, 40, 10]
    }
}