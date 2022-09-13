package algorithm.c5;

import java.util.ArrayDeque;
import java.util.Deque;

public class S547 {
    public int findCircleNum(int[][] isConnected) {
        // Searched
        int n = isConnected.length;
        boolean[] searched = new boolean[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (searched[i]) {
                continue;
            }
            searched[i] = true;
            result++;
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer(i);
            // i的全部邻居
            while (!queue.isEmpty()) {
                int num = queue.poll();
                for (int k = 0; k < n; k++) {
                    if (k != num && isConnected[num][k] == 1 && !searched[k]) {
                        // 一个新的未搜索的连通数字
                        queue.offer(k);
                        searched[k] = true;
                    }
                }
            }
        }
        return result;
    }
}
