package algorithm.c2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class S253 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int max = 1;
        // 这个队列需要按照结束时间排序
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] curr = intervals[i];
            while (pq.isEmpty() == false && pq.peek() <= curr[0]) {
                pq.poll();
            }
            pq.offer(curr[1]);
            max = Math.max(max, pq.size());
        }
        return max;
    }
}
