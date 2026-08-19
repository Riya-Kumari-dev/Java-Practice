package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafe {
    static void main(String[] args) {
        CopyOnWriteArrayList arr = new CopyOnWriteArrayList();
        arr.add(10);
        arr.add(30);
        arr.add(40);
        arr.add("Riya");

        // A fail-safe iterator can continue iterating even if the underlying condition is modified.
        Iterator it = arr.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
            arr.add(49);
        }
    }
}