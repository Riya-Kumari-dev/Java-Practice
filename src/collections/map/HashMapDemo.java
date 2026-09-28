package collections.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    static void main(String[] args) {
        HashMap<Integer, String> students = new HashMap<>();

        // put(k, v) - O(1)
        // Insert or replace; returns previous value (or null)
        students.put(101, "Riya");
        students.put(102, "Aman");
        students.put(103, "Neha");
        students.put(101, "Aditi"); // replaces Riya
        students.put(null, "Unknown"); // can have null as key

        System.out.println("Size = " + students.size()); // 4
        System.out.println(students); // {null=Unknown, 101=Aditi, 102=Aman, 103=Neha}

        // get(k) - O(1)
        // get value ; return null if absent or mapped to null
        System.out.println(students.get(null)); // Unknown

        // remove(k) - O(1)
        // remove mapping
        students.remove(103);

        // containsKey(k) - O(1)
        // Test whether a key exists
        System.out.println("Has key 104 ? "+students.containsKey(104)); // false

        // containsValue(v) - O(n)
        // Search values
        System.out.println("Has value Neha ? "+students.containsValue("Neha")); // false

        // clear()
        // remove all entries
        students.clear();

        // getOrDefault(k, d)
        // default only if key is absent
        students.getOrDefault(101, "Unknown");

        // putIfAbsent(k, v)
        // insert if absent or mapped to null
        students.putIfAbsent(102, "Aditi");
        System.out.println(students); // {102=Aditi}

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 20);
        map.put(2, 40);
        map.put(3, 60);
        map.put(2, null);
        map.put(4, null); // multiple null values allowed

        // merge(k,v,f)
        // insert v if absent/null; otherwise combine
        map.merge(2, 5, Integer :: sum); // 2 = 5

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println("Key : " + entry.getKey()+", Value : "+entry.getValue());
        }
        /*Key : 1, Value : 20
        Key : 2, Value : 5
        Key : 3, Value : 60
        Key : 4, Value : null*/
    }
}