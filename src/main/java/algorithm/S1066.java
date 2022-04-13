package algorithm;

import java.util.Arrays;

public class S1066 {

    int minDistance = Integer.MAX_VALUE;
    int[][] workers;
    int[][] bikes;
    boolean[] used;

    public int assignBikes(int[][] workers, int[][] bikes) {
        // 不知道怎么做
        // 针对每一位工人，选出当前剩余自行车中离他最近的？
        // 这样不知道是不是最优解
        // 看了题解，原来是用dfs找全部情况的题目啊，我无语了
        // 因为最多就10辆车，规模比较小，所以可以穷举

        this.workers = workers;
        this.bikes = bikes;
        this.used = new boolean[bikes.length];
        dfs(0, 0);
        return minDistance;
    }

    void dfs(int w, int distance) {
        if (w == workers.length) {
            minDistance = Math.min(minDistance, distance);
            return;
        }
        int[] curr = workers[w];

        for (int i = 0; i < used.length; i++) {
            if (used[i]) continue;

            int nextDist = distance + Math.abs(curr[0] - bikes[i][0]) + Math.abs(curr[1] - bikes[i][1]);
            if (nextDist > minDistance) continue;
            used[i] = true;
            dfs(w + 1, nextDist);
            used[i] = false;
        }
    }
}
