package algorithm.c3;

import java.util.ArrayDeque;
import java.util.Deque;

public class S317 {
    class Solution {
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};

        public int shortestDistance(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            // 看了题解，就是bfs的纯暴力做法，从每个1出发bfs，然后找到空地的距离
            // 实际上题目也没说清楚到底是空地比较多，还是建筑比较多，如果是建筑比较多、空地比较少的话，那么其实是从0也就是空地出发的bfs更快，但是实际上就是空地比较多
            // 记录累积的距离
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        // 记录单次bfs的结果，想了想也没有什么别的好办法了，因为每一次我都要统计不可达的地方，也就是用一个二维数组最方便了
                        int[][] res = new int[m][n];
                        bfs(i, j, grid, res);
                        getDistance(res, dp);
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][j] == -1) {
                        continue;
                    }
                    min = Math.min(dp[i][j], min);
                }
            }
            return min == Integer.MAX_VALUE ? -1 : min;
        }

        void bfs(int x, int y, int[][] grid, int[][] res) {

            Deque<Node> queue = new ArrayDeque<>();
            queue.offer(new Node(x, y, 0));

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int k = 0; k < size; k++) {
                    Node curr = queue.poll();
                    for (int i = 0; i < 4; i++) {
                        int nx = dx[i] + curr.x;
                        int ny = dy[i] + curr.y;
                        if (nx >= grid.length || nx < 0 || ny >= grid[0].length || ny < 0) {
                            continue;
                        }
                        if (grid[nx][ny] == 0 && res[nx][ny] == 0) {
                            res[nx][ny] = curr.distance + 1;
                            queue.offer(new Node(nx, ny, curr.distance + 1));
                        }
                    }
                }
            }
        }

        void getDistance(int[][] res, int[][] dp) {
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    if (dp[i][j] == -1) {
                        continue;
                    }
                    if (res[i][j] == 0) {
                        dp[i][j] = -1;
                        continue;
                    }
                    dp[i][j] += res[i][j];
                }
            }
        }

        class Node {
            int x;
            int y;
            int distance;

            Node(int x, int y, int dist) {
                this.x = x;
                this.y = y;
                this.distance = dist;
            }
        }
    }
}
