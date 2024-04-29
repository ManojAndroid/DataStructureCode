package LLDDesign.LRUSimple;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LRUCacheFromLeetCode {
    private Map<Integer, Integer> cache;
    private int capacity;

    public LRUCacheFromLeetCode(int capacity) {
        this.cache = new LinkedHashMap<>();
        this.capacity = capacity;

    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            int v = cache.get(key);
            cache.remove(key);
            cache.put(key, v);
            return v;
        } else {
            return -1;
        }

    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
            cache.put(key, value);
            return;

        }
        if (capacity > 0) {
            capacity--;
            cache.put(key, value);
        } else {
            List<Integer> list = new ArrayList(cache.keySet());
            cache.remove(list.get(0));
            cache.put(key, value);
        }

    }
}
