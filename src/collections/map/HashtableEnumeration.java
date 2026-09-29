package collections.map;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashtableEnumeration {
    /*Enumeration :
    - A legacy interface used to traverse elements of legacy collections such as Hashtable and Vector.
    - */
    static void main(String[] args) {
        Hashtable<Integer, String> table = new Hashtable<>();
        table.put(1, "Java");
        table.put(2, "Spring");
        table.put(3, "Microservices");

        // Enumerating values
        Enumeration<Integer> keys = table.keys();
        System.out.print("Keys : ");
        while (keys.hasMoreElements()) { // hasMoreElements() -> checks whether more elements are available.
            System.out.print(keys.nextElement() + " "); // nextElement() -> returns the next element.
        }

        System.out.println();
        // Enumerating values
        Enumeration<String> values = table.elements();
        System.out.print("Values : ");
        while (values.hasMoreElements()) {
            System.out.print(values.nextElement() + " ");
        }
    }
}