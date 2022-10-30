package algorithm.c9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : panjixiang
 * @since : 2022/10/26
 */
public class S981 {
    class TimeMap {

        Map<String, List<Pair>> map = new HashMap<>();

        public TimeMap() {
        }

        public void set(String key, String value, int timestamp) {
            if (map.containsKey(key)) {
                var list = map.get(key);
                // 二分搜索
                int left = 0;
                int right = list.size() ;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (list.get(mid).num > timestamp) {
                        right = mid;
                    } else if (list.get(mid).num == timestamp) {
                        list.get(mid).value = value;
                        return;
                    } else {
                        left = mid + 1;
                    }
                }
                list.add(left, new Pair(timestamp, value));
            } else {
                var list = new ArrayList<Pair>();
                list.add(new Pair(timestamp, value));
                map.put(key, list);
            }
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) {
                return null;
            }
            var list = map.get(key);
            int left = 0;
            int right = list.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (list.get(mid).num > timestamp) {
                    right = mid;
                } else if (list.get(mid).num == timestamp) {
                    return list.get(mid).value;
                } else {
                    left = mid + 1;
                }
            }
            System.out.println(map.get(key));
            System.out.println(left);
            return list.get(left).value;
        }
    }

    class Pair implements Comparable<Pair> {
        int num;
        String value;

        Pair(int num, String value) {
            this.num = num;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.num == o.num) {
                return this.value.compareTo(o.value);
            }
            return this.num - o.num;
        }

        @Override
        public String toString() {
            return this.num + " " + this.value;
        }
    }
}
