package algorithm.C7;

import java.util.TreeMap;

public class S731c {
    class MyCalendarTwo {
        // 抄的，很漂亮，比我自己蠢蠢去判断强太多了，开始一个就+1，结束一个就-1，那么按时间线统计，只要大于等于3就是要3个在同时活跃的

        private final TreeMap<Integer, Integer> calendar;

        public MyCalendarTwo() {
            calendar = new TreeMap<>();
        }

        public boolean book(int start, int end) {

            // 尝试添加至日程中
            calendar.put(start, calendar.getOrDefault(start, 0) + 1);
            calendar.put(end, calendar.getOrDefault(end, 0) - 1);

            // 记录活跃的日程数
            int active = 0;

            for (int d : calendar.values()) {
                // 以时间线统计日程
                active += d;

                // 中途活跃日程>=3时，返回 false
                if (active >= 3) {

                    // 恢复现场
                    calendar.put(start, calendar.get(start) - 1);
                    calendar.put(end, calendar.get(end) + 1);

                    if (calendar.get(start) == 0) {
                        calendar.remove(start);
                    }

                    return false;
                }
            }
            return true;
        }
    }
}
