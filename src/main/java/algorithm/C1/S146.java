package algorithm.C1;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* LRUCache */
class S146 {

    private LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    private final int capacity;

    public S146(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else if (map.size() == capacity) {
            Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
            it.next();
            it.remove();
        }
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */