package algorithm.C4;

import java.util.Arrays;

public class S435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 选出最大数量的区间，它们不重叠
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int end = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] >= end) {
                count++;
                end = curr[1];
            } else {
                end = Math.min(end, curr[1]);
            }
        }
        return intervals.length - count;
    }
}
