package algorithm.C4;

import java.util.PriorityQueue;

public class S407 {
    class Solution {
        public int trapRainWater(int[][] heightMap) {
            if (heightMap.length <= 2 || heightMap[0].length <= 2) {
                return 0;
            }
            int m = heightMap.length;
            int n = heightMap[0].length;
            boolean[][] visit = new boolean[m][n];
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    // 最外圈的
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        // 索引，高度
                        pq.offer(new int[] {i * n + j, heightMap[i][j]});
                        visit[i][j] = true;
                    }
                }
            }
            int res = 0;
            int[] dirs = {-1, 0, 1, 0, -1};
            while (!pq.isEmpty()) {
                // 木桶最低处
                int[] curr = pq.poll();
                for (int k = 0; k < 4; ++k) {
                    // 找它四周没有访问的
                    int nx = curr[0] / n + dirs[k];
                    int ny = curr[0] % n + dirs[k + 1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visit[nx][ny]) {
                        // 如果当前高度比它高，而curr1已经是四周最矮的了
                        if (curr[1] > heightMap[nx][ny]) {
                            res += curr[1] - heightMap[nx][ny];
                        }
                        pq.offer(new int[] {nx * n + ny, Math.max(heightMap[nx][ny], curr[1])});
                        visit[nx][ny] = true;
                    }
                }
            }
            return res;
        }
    }

    //自己写的错的
    class Solution2 {
        public int trapRainWater(int[][] heightMap) {
            // 每行搜一下，每列搜一下，取最小值
            // 不能只是这么做，因为是三维的所以水位会互相联通，只能达到一个范围的最低值
            int m = heightMap.length;
            int n = heightMap[0].length;

            int[][] res = new int[m][n];
            for (int i = 0; i < m; i++) {
                int[] row = heightMap[i];
                int left = 0;
                int right = n - 1;
                int leftMax = 0;
                int rightMax = 0;
                while (left < right) {
                    if (row[left] < row[right]) {
                        leftMax = Math.max(leftMax, row[left]);
                        res[i][left] = leftMax - row[left];
                        left++;
                    } else {
                        rightMax = Math.max(rightMax, row[right]);
                        res[i][right] = rightMax - row[right];
                        right--;
                    }
                }
            }

            int ans = 0;
            for (int j = 0; j < n; j++) {
                int up = 0;
                int down = m - 1;
                int upMax = 0;
                int downMax = 0;
                while (up < down) {
                    if (heightMap[up][j] < heightMap[down][j]) {
                        upMax = Math.max(upMax, heightMap[up][j]);
                        res[up][j] = Math.min(res[up][j], upMax - heightMap[up][j]);
                        ans += res[up][j];
                        up++;
                    } else {
                        downMax = Math.max(downMax, heightMap[down][j]);
                        res[down][j] = Math.min(res[down][j], downMax - heightMap[down][j]);
                        ans += res[down][j];
                        down--;
                    }
                }
            }
            return ans;
        }
    }
}
