package collections.map;

import java.util.Hashtable;

public class HashtableDemo {
    /*Hashtable :
     - Legacy map implementation that stores data in key-value pairs.
     - Synchronized.
     - Does not allow null keys or null values.
     - Does not maintain insertion order.*/
    static void main(String[] args) {
        Hashtable<Integer, String> table = new Hashtable<>();
        table.put(1, "ZCA");
        table.put(2, "DGS");
        table.put(3, "BPS");
        // keys and values cannot be null
        // table.put(null, "Unknown"); // NullPointerException
        table.put(4, "Amity");
        // table.put(5, null); // NullPointerException

        System.out.println(table.get(2)); // DGS
        System.out.println(table); // {4=Amity, 3=BPS, 2=DGS, 1=ZCA}

        System.out.println(table.containsKey(1)); // true
    }
}