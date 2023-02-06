package algorithm.c9;

/**
 * @author : panjixiang
 * @since : 2022/9/19
 */
public class S959 {

    class Solution {
        // 一个方格分成四块
        public static final int UP = 0;
        public static final int RIGHT = 1;
        public static final int DOWN = 2;
        public static final int LEFT = 3;
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        public int regionsBySlashes(String[] grid) {
            int n = grid.length;
            char[][] g = new char[n][n];
            for (int i = 0; i < grid.length; i++) {
                char[] chars = grid[i].toCharArray();
                System.arraycopy(chars, 0, g[i], 0, n);
            }

            var uf = new UnionFind(n * n * 4);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dirs[k][0];
                        int y = j + dirs[k][1];
                        if (x < 0 || y < 0 || x >= n || y >= n) {
                            continue;
                        }

                        uf.union(4 * (i * n + j) + k, 4 * (x * n + y) + ((k + 2) % 4));
                    }

                    switch (g[i][j]) {
                        case ' ' -> {
                            for (int m = 1; m <= 3; m++) {
                                uf.union(4 * (i * n + j), 4 * (i * n + j) + m);
                            }
                        }
                        case '\\' -> {
                            uf.union(4 * (i * n + j) + UP, 4 * (i * n + j) + RIGHT);
                            uf.union(4 * (i * n + j) + LEFT, 4 * (i * n + j) + DOWN);
                        }
                        case '/' -> {
                            uf.union(4 * (i * n + j) + UP, 4 * (i * n + j) + LEFT);
                            uf.union(4 * (i * n + j) + RIGHT, 4 * (i * n + j) + DOWN);
                        }
                    }
                }
            }
            return uf.groups;
        }
    }

    class UnionFind {
        int[] root;
        int groups;

        UnionFind(int N) {
            this.root = new int[N];
            for (int i = 0; i < N; i++) {
                root[i] = i;
            }
            this.groups = N;
        }

        int findRoot(int x) {
            while (root[x] != x) {
                root[x] = findRoot(root[x]);
                x = root[x];
            }
            return root[x];
        }

        void union(int x, int y) {

            int a = findRoot(x);
            int b = findRoot(y);
            if (a != b) {
                groups--;
                root[a] = b;
            }
        }
    }
}