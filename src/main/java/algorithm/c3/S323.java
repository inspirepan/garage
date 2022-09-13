package algorithm.c3;

public class S323 {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        uf.count = n;
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (!uf.isConnected(a, b)) {
                uf.union(a, b);
            }
        }
        return uf.count;
    }

    class UnionFind {

        int[] root;
        int count = 0;

        UnionFind(int n) {
            this.root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
        }

        boolean isConnected(int x, int y) {
            return find(x) == find(y);
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
                root[a] = root[b];
                count--;
            }
        }
    }
}
