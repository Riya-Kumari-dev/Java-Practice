package collections;

import java.util.Collection;
import java.util.HashMap;

public class HashMapDemo {
    static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "SpringBoot");
        map.put(3, "Python");

        System.out.println(map.get(1));
        map.remove(1);
        System.out.println(map);
    }
}
