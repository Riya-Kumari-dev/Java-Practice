package collections;

import java.util.TreeSet;

public class TreeSetDemo {
    /* TreeSet :
    -> Implements NavigableSet interface which extends SortedSet and Set.
    -> Its main characteristics are unique elements and sorted order.
    -> TreeSet is backed by a TreeMap, and TreeMap internally uses a Red-Black Tree. A Red-Black Tree is a self-balancing Binary Search Tree.
    -> All the operations of TreeSet has Time Complexity of O(log(n)) because the underlying structure is a balanced Red-Black Tree.
    * */
    static void main(String[] args) {
        TreeSet ts = new TreeSet();
        ts.add(10);
        ts.add(40);
        ts.add(34);
        ts.add(56);
        ts.add(43);
        ts.add(12);

        System.out.println(ts); // [10, 12, 34, 40, 43, 56]

        System.out.println(ts.first()); // 10 -> Returns the smallest element
        System.out.println(ts.last()); // 56 -> Returns the largest element

        System.out.println(ts.lower(34)); // 12 -> Returns the greatest element strictly less than x. => lower() -> <
        System.out.println(ts.floor(34)); // 34 -> Returns the greatest element <= x
        System.out.println(ts.higher(34)); // 40->  Returns the smallest element strictly greater than x. => higher() -> >
        System.out.println(ts.ceiling(34)); // 34 -> Returns the smallest element >= x

        System.out.println(ts.lower(10)); // null
        System.out.println(ts.floor(10)); // 10
        System.out.println(ts.higher(56)); // null
        System.out.println(ts.ceiling(56)); // 56


        System.out.println(ts.tailSet(23)); // [34, 40, 43, 56]
        System.out.println(ts.headSet(23)); // [10, 12]
        System.out.println(ts.pollFirst()); // 10 -> returns and removes the smallest element
        System.out.println(ts.pollLast()); // 56 -> returns and removes the largest element

        System.out.println(ts); // [12, 34, 40, 43]

        System.out.println(ts.descendingSet()); // [43, 40, 34, 12] -> descending order view
        System.out.println(ts.first()); // 12 -> tree is not modified
    }
}