package algorithm;

import java.util.Arrays;

public class S1101 {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        UnionFind uf = new UnionFind(n);
        for (int[] log : logs) {
            if (!uf.isConnected(log[1], log[2])) {
                uf.union(log[1], log[2]);
                if (uf.groups == 1) {
                    return log[0];
                }
            }
        }
        return -1;
    }

    class UnionFind {
        int[] root;
        int groups;

        UnionFind(int n) {
            this.root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
            groups = n;
        }

        int find(int x) {
            while (root[x] != x) {
                root[x] = find(root[x]);
                x = root[x];
            }
            return root[x];
        }

        void union(int x, int y) {
            int a = find(x);
            int b = find(y);
            if (a != b) {
                groups--;
                root[a] = b;
            }
        }

        boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
