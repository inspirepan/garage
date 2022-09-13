package algorithm.c3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S380 {
    class RandomizedSet {
        // Value, Index
        Map<Integer, Integer> map = new HashMap<>();
        // List Of Value
        List<Integer> list = new ArrayList<>();

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            if (!map.containsKey(val)) {
                list.add(val);
                map.put(val, list.size() - 1);
                return true;
            }
            return false;
        }

        public boolean remove(int val) {
            // Always remove the lastOne
            if (map.containsKey(val)) {
                int index = map.get(val);
                if (index != list.size() - 1) {
                    // 如果不是队尾的元素，和它交换
                    int lastVal = list.get(list.size() - 1);
                    list.set(index, lastVal);
                    map.put(lastVal, index);
                }
                list.remove(list.size() - 1);
                map.remove(val);
                return true;
            }
            return false;
        }

        public int getRandom() {
            int size = list.size();
            int random = (int) (Math.random() * size);
            // 返回第random个
            return list.get(random);
        }
    }
}
