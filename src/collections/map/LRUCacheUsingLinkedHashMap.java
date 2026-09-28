package collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest){
        return size() > capacity;
    }
}
public class LRUCacheUsingLinkedHashMap {
    static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "Java");
        cache.put(2, "Python");
        cache.put(3, "C++");

        // initial : 1 -> 2 -> 3
        System.out.println(cache); // {1=Java, 2=Python, 3=C++}

        // access key
        cache.get(1); // 2 -> 3 -> 1

        System.out.println(cache); // {2=Python, 3=C++, 1=Java}

        cache.put(4, "JavaScript"); // 3 -> 1 -> 4
        // 2 was the least recently used, so it was automatically removed.
        System.out.println(cache); // {3=C++, 1=Java, 4=JavaScript}
    }
}