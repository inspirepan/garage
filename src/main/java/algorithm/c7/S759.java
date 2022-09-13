package algorithm.c7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class S759 {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        // 合并员工的工作时间，然后给出中间值
        PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        });
        for (List<Interval> l : schedule) {
            for (Interval i : l) {
                pq.offer(i);
            }
        }
        List<Interval> workTime = new ArrayList<>();
        while (!pq.isEmpty()) {
            Interval curr = pq.poll();
            if (workTime.isEmpty()) {
                workTime.add(curr);
            } else {
                int lastEnd = workTime.get(workTime.size() - 1).end;
                if (lastEnd >= curr.start) {
                    workTime.get(workTime.size() - 1).end = Math.max(lastEnd, curr.end);
                } else {
                    workTime.add(curr);
                }
            }
        }
        List<Interval> availableTime = new ArrayList<>();
        if (workTime.size() == 1) {
            return availableTime;
        }
        for (int i = 0; i < workTime.size() - 1; i++) {
            availableTime.add(new Interval(workTime.get(i).end, workTime.get(i + 1).start));
        }
        return availableTime;
    }

    class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }
}
