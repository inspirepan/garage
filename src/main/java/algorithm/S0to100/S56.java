package algorithm.S0to100;

import java.util.*;

/**
 * @author panjx
 */
public class S56 {
    /**
     * @param intervals 输入
     * @return 输出
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        var list = new ArrayList<int[]>();
        var prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (prev[1] >= intervals[i][0]) {
                if (prev[1] > intervals[i][1]) {
                    intervals[i][0] = prev[0];
                    intervals[i][1] = prev[1];
                } else {
                    intervals[i][0] = prev[0];
                }
            } else {
                list.add(prev.clone());
            }
            prev = intervals[i];
        }
        list.add(intervals[intervals.length - 1]);
        return list.toArray(new int[list.size()][2]);
    }

    /**
     * 用Map记录每个边界出现的次数，（左边界+1，右边界-1）
     * 最后按顺序统计
     *
     * @param intervals 输入
     * @return 输出
     */
    public int[][] merge2(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] interval : intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1], map.getOrDefault(interval[1], 0) - 1);
        }
        Object[] keyArr = map.keySet().toArray();
        Arrays.sort(keyArr);
        // 状态，是否在区间中？
        boolean in = false;
        int sum = 0;
        List<int[]> result = new ArrayList<>();
        int[] curr = new int[2];
        for (Object k : keyArr) {
            int val = map.get(k);
            if (val == 0) {
                if (!in) {
                    curr[0] = (int) k;
                    curr[1] = (int) k;
                    result.add(curr.clone());
                }
                continue;
            }
            if (sum == 0) {
                curr[0] = (int) k;
                in = true;
            }
            sum += val;
            if (sum == 0) {
                curr[1] = (int) k;
                in = false;
                result.add(curr.clone());
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
