package algorithm.c7;

import java.util.TreeMap;
import java.util.TreeSet;

public class S729 {
    class MyCalendar {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            Integer less = map.floorKey(start);
            if (less != null) {
                if (map.get(less) > start) {
                    return false;
                }
            }
            Integer higher = map.ceilingKey(start);
            if (higher != null) {
                if (higher < end) {
                    return false;
                }
            }
            map.put(start, end);
            return true;
        }
    }

    class MyCalendar2 {

        TreeSet<Event> set = new TreeSet<>();

        public MyCalendar2() {

        }

        public boolean book(int start, int end) {
            Event e = new Event(start, end);

            Event last = set.floor(e);
            if (last != null) {
                if (last.end > start) {
                    return false;
                }
            }
            Event next = set.ceiling(e);
            if (next != null) {
                if (next.start < end) {
                    return false;
                }
            }
            set.add(e);
            return true;
        }

        class Event implements Comparable<Event> {
            int start;
            int end;

            Event(int start, int end) {
                this.start = start;
                this.end = end;
            }

            @Override
            public int compareTo(Event o) {
                if (this.start == o.start) {
                    return this.end - o.end;
                }
                return this.start < o.start ? -1 : 1;
            }
        }
    }
}
