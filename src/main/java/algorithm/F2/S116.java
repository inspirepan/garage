package algorithm.F2;

import java.util.HashSet;
import java.util.Set;

public class S116 {
    public int findCircleNum(int[][] isConnected) {
        // 并查集
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(uf.find(i));
        }
        return set.size();
    }

    class UnionFind {
        int[] root;
        int[] height;

        UnionFind(int n) {
            this.root = new int[n];
            this.height = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
        }

        int find(int x) {
            while (x != root[x]) {
                root[x] = find(root[x]);
                x = root[x];
            }
            return root[x];
        }

        void union(int x, int y) {
            int a = find(x);
            int b = find(y);
            if (a != b) {
                if (height[a] == height[b]) {
                    root[b] = root[a];
                    height[a]++;
                } else if (height[a] > height[b]) {
                    root[b] = root[a];
                } else {
                    root[a] = root[b];
                }
            }
        }
    }
}
