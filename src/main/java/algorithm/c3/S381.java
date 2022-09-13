package algorithm.c3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class S381 {
    class RandomizedCollection {
        // 这道题数据量太大了，LinkedList因为要set指定位置的，直接暴毙，要1700ms
        // 换成ArrayList就快太多了
        // 和上一题的思路一毛一样的，就是每次把remove的元素弄到List的末尾，进行一次交换
        // 不过为了容许重复的元素，用Set保留多个Index
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();

        public RandomizedCollection() {

        }

        public boolean insert(int val) {
            list.add(val);
            var set = map.getOrDefault(val, new HashSet<>());
            set.add(list.size() - 1);
            map.put(val, set);
            return set.size() == 1;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            // 最后一个元素就是val
            if (list.get(list.size() - 1) == val) {
                list.remove(list.size() - 1);
                map.get(val).remove(list.size());
                if (map.get(val).size() == 0) {
                    map.remove(val);
                }
                return true;
            }

            var set = map.get(val);
            var it = set.iterator();
            int first = it.next();
            // 交换
            int lastVal = list.get(list.size() - 1);
            list.set(first, lastVal);
            map.get(lastVal).add(first);
            map.get(lastVal).remove(list.size() - 1);
            list.remove(list.size() - 1);

            set.remove(first);
            if (set.size() == 0) {
                map.remove(val);
            }
            return true;
        }

        public int getRandom() {
            return list.get((int) (Math.random() * list.size()));
        }
    }
}
