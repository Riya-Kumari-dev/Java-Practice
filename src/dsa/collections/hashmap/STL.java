package dsa.collections.hashmap;

import java.util.HashMap;

public class STL {
    static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        // adding
        map.put("Riya",1); map.put("Priya",2); map.put("Adhvik",3);
        map.put("Krishna",1); map.put("Arjun",5); map.put("Sanya",4);

        System.out.println(map);

        map.putIfAbsent("Nitya", 5); // if the key is not present then assigned and add to the map
        map.put("Riya",2); // now Riya has new mapping 2
        map.putIfAbsent("Priya", 1); // no changes as it is already present

        // get
        System.out.println(map.get("Priya"));
        System.out.println(map.getOrDefault("Riya", -1)); // if not present give the default value
        System.out.println(map.getOrDefault("Natasha", -1));

        // printing
        System.out.println(map);
        // using for-each
        for(String key : map.keySet()){
            System.out.print(key+"="+map.get(key)+" ");
        }

        // remove
        System.out.println(map.remove("Nitya")); // true
        System.out.println(map);

        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }
}