package algorithm.C7;

public class S785 {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        UnionFind uf = new UnionFind(2 * n);
        for (int i = 0; i < n; i++) {
            for (int node : graph[i]) {
                if (uf.isConnected(i, node)) return false;
                uf.union(i, node + n);
                uf.union(i + n, node);
            }
        }
        return true;
    }

    class UnionFind {
        int[] root;
        int[] height;

        UnionFind(int N) {

            this.root = new int[N];
            this.height = new int[N];
            for (int i = 0; i < N; i++) {
                root[i] = i;
            }
        }

        int find(int x) {
            while (root[x] != x) {
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
                if (height[a] >= height[b]) {
                    root[b] = root[a];
                    if (height[a] == height[b]) {
                        height[a]++;
                    }
                } else {
                    root[a] = root[b];
                }
            }
        }
    }
}
