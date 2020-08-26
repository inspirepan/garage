package algorithm;

import java.util.ArrayList;

/**
 * 这道题就是一次for循环解决，需要用两个布尔变量记录两个新边界有没有安排好。
 *
 * @author panjx
 * @date 8.26 新写的
 */
public class S57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        int start = newInterval[0], end = newInterval[1];
        var result = new ArrayList<int[]>();
        boolean startSettled = false, endSettled = false;
        for (int[] curr : intervals) {
            // 如果都已安排好
            if (endSettled) {
                result.add(new int[]{curr[0], curr[1]});
                continue;
            }
            // 还没找到start
            if (!startSettled) {
                if (curr[1] < start) {
                    result.add(new int[]{curr[0], curr[1]});
                    continue;
                } else {
                    startSettled = true;
                    start = Math.min(start, curr[0]);
                }
            }
            // 剩下的情况就是找到start后的处理
            if (curr[0] <= end && end <= curr[1]) {
                endSettled = true;
                end = curr[1];
                result.add(new int[]{start, curr[1]});
            } else if (end < curr[0]) {
                endSettled = true;
                result.add(new int[]{start, end});
                result.add(new int[]{curr[0], curr[1]});
            }
            // end还没找到的话交给下一项处理
        }
        // 这一步很重要，一定要记得最后再加上去，如果end大于现有范围的最大值，就会加不上。
        // 原[3,4]，新[1,6]
        // 原[3,4]，新[5,6]
        if (!endSettled) {
            result.add(new int[]{start, end});
        }
        return result.toArray(new int[result.size()][2]);
    }
}
