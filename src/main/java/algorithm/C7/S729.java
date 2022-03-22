package algorithm.C7;

import java.util.TreeMap;

public class S729 {
    class MyCalendar {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            Integer less = map.floorKey(start);
            if (less != null) {
                if (map.get(less) > start) return false;
            }
            Integer higher = map.ceilingKey(start);
            if (higher != null) {
                if (higher < end) return false;
            }
            map.put(start, end);
            return true;
        }
    }
}
