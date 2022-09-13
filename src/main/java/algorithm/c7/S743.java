package algorithm.c7;

import java.util.Arrays;

public class S743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] results = new int[n];
        Arrays.fill(results, Integer.MAX_VALUE);
        results[k - 1] = 0;
        // 因为数据量比较小，所以直接遍历全部的边比较快
        while (true) {
            boolean end = true;
            for (int[] time : times) {
                // 起点尚未可达，跳过
                if (results[time[0] - 1] == Integer.MAX_VALUE) {
                    continue;
                }
                // 起点+当前距离大于已计算的距离，跳过
                if (results[time[0] - 1] + time[2] >= results[time[1] - 1]) {
                    continue;
                }
                // 更新最短距离
                results[time[1] - 1] = results[time[0] - 1] + time[2];
                end = false;
            }
            if (end) {
                break;
            }
        }
        int num = Arrays.stream(results).max().getAsInt();
        return num == Integer.MAX_VALUE ? -1 : num;
    }
}
