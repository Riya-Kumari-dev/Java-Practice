package collections;

import java.util.ArrayDeque;

public class ArrayDequeDemo {
    /*ArrayDeque :
    -> Implements the Deque (Double Ended Queue) interface.
    -> A dequeue allows insertion and removal from both ends.
    -> Internally uses a resizable circular array.
    -> The circular nature means, that when an end reaches the physical end of the array, it can wrap around and use free space at the beginning.
    -> Does not allow null elements.

     */
    static void main(String[] args) {
        ArrayDeque ar = new ArrayDeque();
        // add()
        // -> add to the last
        ar.add(20);
        ar.add("Riya");
        ar.add("Natasha");
        ar.add("Java");
        ar.add(3.2);
        System.out.println(ar); // [20, Riya, Natasha, Java, 3.2]

        ArrayDeque ar2 = new ArrayDeque();
        ar2.addFirst(30);
        ar2.addLast(50);
        ar.addAll(ar2);

        ar.push("Nitya"); // add to the first

        System.out.println(ar); // [Nitya, 20, Riya, Natasha, Java, 3.2, 30, 50]

        // remove
        ar.remove(); // remove the first element
        ar.pop(); // remove the first element
        ar.removeLast();
        System.out.println(ar.poll());// Riya -> removes the first element ->  returns null if the deque is empty.
        // while pop and remove throw NoSuchElementException.
        System.out.println(ar);  // [Natasha, Java, 3.2, 30]

        System.out.println(ar.peek()); // Natasha -> returns the first element ->  returns null if the deque is empty
    }
}
