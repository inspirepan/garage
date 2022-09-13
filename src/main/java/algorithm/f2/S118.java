package algorithm.f2;

public class S118 {
    public int[] findRedundantConnection(int[][] edges) {
        // 并查集典型题
        // 依次扫描边
        // 出现两个节点已经在一组里面的情况，说明这个边形成了环，返回即可
        int n = edges.length;
        UnionFind uf = new UnionFind(n);
        for (var edge : edges) {
            int a = edge[0] - 1, b = edge[1] - 1;
            if (uf.isConnected(a, b)) {
                return edge;
            }
            uf.union(a, b);
        }
        return new int[2];
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

        boolean isConnected(int x, int y) {
            return find(x) == find(y);
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
