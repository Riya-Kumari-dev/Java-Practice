package collections;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDemo {
    /* Iterator :
    -> an interface from java.util used to traverse collection elements one by one.
    -> especially useful for collections that don't provide index-based access, such as HashSet.
    * */
    static void main(String[] args) {
        ArrayList arr = new ArrayList();
        arr.add(10);
        arr.add(30);
        arr.add(40);
        arr.add("Riya");

        // infinite loop -> concurrent modification
//        for(int i=0; i<arr.size(); i++){
//            System.out.println(arr.get(i));
//            arr.add(45);
//        }

        Iterator it = arr.iterator();

        while(it.hasNext()){ // hasNext() -> checks whether another element is available. Doesn't move the iterator.
            System.out.println(it.next()); // next() -> returns the next element, moves the iterator forward.
        }


        // fail-fast
//        while(it.hasNext()){
//            System.out.println(it.next());
//            arr.add(45); // Don't directly structurally modify the collection, while an iterator is active, this can result in ConcurrentModificationException.
//        }

    }
}