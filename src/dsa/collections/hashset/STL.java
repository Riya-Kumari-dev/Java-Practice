package dsa.collections.hashset;

import java.util.HashSet;

public class STL {
    static void main(String[] args) {
        // Constructs a new, empty set; the backing HashMap instance has default initial capacity (16) and load factor (0.75).
        HashSet<Integer> set = new HashSet<>();

        // add() => Adds the specified element to this set if it is not already present.
        set.add(2); set.add(3); set.add(5); set.add(40);
        set.add(0); set.add(3); set.add(6); set.add(30);

        System.out.println(set);

        System.out.println(set.size());
        System.out.println(set.isEmpty());

        // contains()
        // Returns true if this set contains the specified element
        System.out.println(set.contains(2));
        System.out.println(set.contains(43));

        // remove();
        // Removes the specified element from this set if it is present
        set.remove(2);
        System.out.println(set);

        // Removes all the elements from this set. The set will be empty after this call returns.
        set.clear();

        System.out.println(set);
    }
}