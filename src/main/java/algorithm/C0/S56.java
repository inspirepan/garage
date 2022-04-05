package algorithm.C0;

import java.util.*;

public class S56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] prev = res.get(res.size() - 1);

            if (prev[1] >= curr[0]) {
                prev[1] = Math.max(curr[1], prev[1]);
            } else {
                res.add(curr);
            }
        }
        int[][] result = new int[res.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}