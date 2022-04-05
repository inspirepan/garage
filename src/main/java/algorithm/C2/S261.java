package algorithm.C2;

public class S261 {
    public boolean validTree(int n, int[][] edges) {
        int edgeCount = edges.length;
        if (edgeCount != n - 1) return false;
        // 查看有没有重复的边
        Find uf = new Find(n);
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (uf.isConnected(a, b)) return false;
            uf.union(a, b);
        }
        return true;
    }

    class Find {
        int[] root;

        Find(int n) {
            this.root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
        }

        int findRoot(int x) {
            while (root[x] != x) {
                root[x] = findRoot(root[x]);
                x = root[x];
            }
            return root[x];
        }

        boolean isConnected(int x, int y) {
            return findRoot(x) == findRoot(y);
        }

        void union(int x, int y) {
            int a = findRoot(x);
            int b = findRoot(y);
            if (a != b) {
                root[a] = b;
            }
        }
    }
}
