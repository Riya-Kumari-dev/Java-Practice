package collections.map;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {
    /*LinkedHashMap :
    * - Map implementation that stores data as key-value pairs just like HashMap.
    * - LinkedHashMap maintains the insertion order.
    * - Internally it combines HashMap + Doubly LinkedList*/
    static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(4, "Java");
        map.put(2, "Python");
        map.put(3, "C++");
        map.put(null, "JavaScript");
        map.put(5, null);
        map.put(6, null);

        System.out.println(map); // {4=Java, 2=Python, 3=C++, null=JavaScript, 5=null, 6=null}
        System.out.println(map.get(2)); // Python
        map.remove(3);

        System.out.println(map); // {4=Java, 2=Python, null=JavaScript, 5=null, 6=null}

        LinkedHashMap<Integer, String> map2 = new LinkedHashMap<>(16, 0.75f, true); // true for maintaining access order
        map2.put(1, "Riya");
        map2.put(0, "Adhvik");
        map2.put(2, "Shreya");
        map2.put(5, "Sanvi");

        System.out.println(map2); // {1=Riya, 0=Adhvik, 2=Shreya, 5=Sanvi}
    }
}