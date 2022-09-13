package algorithm.C7;

import java.util.TreeMap;

public class S732 {
    // 抄到了第二问别人的时间线统计思路之后，这个题就很容易解了

    class MyCalendarThree {

        private final TreeMap<Integer, Integer> calendar;

        public MyCalendarThree() {
            calendar = new TreeMap<>();
        }

        public int book(int start, int end) {
            // 尝试添加至日程中
            calendar.put(start, calendar.getOrDefault(start, 0) + 1);
            calendar.put(end, calendar.getOrDefault(end, 0) - 1);
            // 记录活跃的日程数
            int active = 0;
            int k = 0;
            for (int d : calendar.values()) {
                // 以时间线统计日程
                active += d;
                k = Math.max(active, k);
            }
            return k;
        }
    }
}
