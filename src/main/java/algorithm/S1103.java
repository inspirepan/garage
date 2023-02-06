package algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class S1103 {
    class Solution {
        // 搜索每个分数是否可达，而不是搜索全部的情况，这样可以剪枝
        private boolean isValid(int[][] grid, int limit, boolean[][] marked, int[] dirs, int i, int j, int m, int n) {
            marked[i][j] = true;
            if (i == m - 1 && j == n - 1) {
                return true;
            }
            for (int k = 0; k < 4; k++) {
                int ni = i + dirs[k];
                int nj = j + dirs[k + 1];
                if (ni >= 0 && nj >= 0 && ni < m && nj < n && !marked[ni][nj] && grid[ni][nj] >= limit) {
                    if (isValid(grid, limit, marked, dirs, ni, nj, m, n)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public int maximumMinimumPath(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int left = 1;
            int right = Math.min(grid[0][0], grid[m - 1][n - 1]);
            int[] dirs = new int[]{0, 1, 0, -1, 0};
            int result = 0;
            while (left <= right) {
                int mid = (left + right) / 2;
                boolean[][] visited = new boolean[m][n];
                if (isValid(grid, mid, visited, dirs, 0, 0, m, n)) {
                    result = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return result;
        }
    }

    class Solution2 {
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int R;
        int C;

        public int maximumMinimumPath(int[][] grid) {
            R = grid.length;
            C = grid[0].length;

            PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
                public int compare(Point o1, Point o2) {
                    return o2.w - o1.w;
                }
            });
            pq.add(new Point(0, grid[0][0]));

            boolean[][] visited = new boolean[R][C];
            while (!visited[R - 1][C - 1]) {
                Point cur = pq.remove();
                int r = cur.p / C;
                int c = cur.p % C;

                if (visited[r][c]) {
                    continue;
                }
                visited[r][c] = true;

                if (r == R - 1 && c == C - 1) {
                    return cur.w;
                }

                for (int i = 0; i < 4; ++i) {
                    int nextr = r + dirs[i][0];
                    int nextc = c + dirs[i][1];
                    int next = nextr * C + nextc;
                    if (isValid(nextr, nextc) && !visited[nextr][nextc]) {
                        Point point = new Point(next, Math.min(cur.w, grid[nextr][nextc]));
                        pq.add(point);
                    }
                }
            }
            return 0;
        }

        public boolean isValid(int r, int c) {
            return r >= 0 && c >= 0 && r < R && c < C;
        }

        private class Point {
            int p;
            int w;

            public Point(int p, int w) {
                this.p = p;
                this.w = w;
            }
        }
    }
}
