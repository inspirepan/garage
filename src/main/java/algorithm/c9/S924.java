package algorithm.c9;

import java.util.Arrays;

/**
 * @author : panjixiang
 * @since : 2022/9/17
 */
public class S924 {
    class Solution {
        public int minMalwareSpread(int[][] graph, int[] initial) {
            int N = graph.length;
            UnionFind uf = new UnionFind(N);
            for (int i = 0; i < N; ++i) {
                for (int j = i + 1; j < N; ++j) {
                    if (graph[i][j] == 1) {
                        uf.union(i, j);
                    }
                }
            }

            int[] count = new int[N];
            for (int node : initial) {
                count[uf.root(node)]++;
            }

            int ans = -1, ansSize = -1;
            for (int node : initial) {
                int root = uf.root(node);
                if (count[root] == 1) {  // unique color
                    int rootSize = uf.size(root);
                    if (rootSize > ansSize) {
                        ansSize = rootSize;
                        ans = node;
                    } else if (rootSize == ansSize && node < ans) {
                        ansSize = rootSize;
                        ans = node;
                    }
                }
            }

            if (ans == -1) {
                ans = Integer.MAX_VALUE;
                for (int node : initial) {
                    ans = Math.min(ans, node);
                }
            }
            return ans;
        }
    }

    class UnionFind {
        int[] p, size;

        UnionFind(int n) {
            p = new int[n];
            for (int x = 0; x < n; ++x) {
                p[x] = x;
            }
            size = new int[n];
            Arrays.fill(size, 1);
        }

        public int root(int x) {
            if (p[x] != x) {
                p[x] = root(p[x]);
            }
            return p[x];
        }

        public void union(int x, int y) {
            int xr = root(x);
            int yr = root(y);
            p[xr] = yr;
            size[yr] += size[xr];
        }

        public int size(int x) {
            return size[root(x)];
        }
    }
}
