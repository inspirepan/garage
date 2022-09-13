package algorithm.F2;

import java.util.Arrays;

public class S105 {
    public int maxAreaOfIsland(int[][] grid) {
        // bfs的会写，写一个并查集的玩玩
        int m = grid.length;
        int n = grid[0].length;
        Graph g = new Graph(m, n);
        boolean hasIsland = false;
        int[] dx = new int[] {-1, 0};
        int[] dy = new int[] {0, -1};
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] == 1) {
                    hasIsland = true;
                    for (int k = 0; k < dx.length; k++) {
                        int nx = dx[k] + x;
                        int ny = dy[k] + y;
                        if (nx >= 0 && ny >= 0 && grid[nx][ny] == 1) {
                            g.union(g.index(nx, ny), g.index(x, y));
                        }
                    }
                }
            }
        }
        // 注意最小值
        if (!hasIsland) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < g.size.length; i++) {
            max = Math.max(max, g.size[i]);
        }
        return max;
    }

    class Graph {
        // 二维的并查集
        int[] root;
        int[] size;
        int M;
        int N;

        Graph(int m, int n) {
            M = m;
            N = n;
            root = new int[m * n];
            size = new int[m * n];
            for (int i = 0; i < root.length; i++) {
                root[i] = i;
            }
            Arrays.fill(size, 1);
        }

        int index(int x, int y) {
            return x * N + y;
        }

        int find(int index) {
            while (index != root[index]) {
                root[index] = find(root[index]);
                index = root[index];
            }
            return root[index];
        }

        void union(int a, int b) {
            int x = find(a);
            int y = find(b);
            if (x != y) {
                if (size[x] >= size[y]) {
                    root[y] = x;
                    size[x] += size[y];
                } else {
                    root[x] = y;
                    size[y] += size[x];
                }
            }
        }
    }
}
