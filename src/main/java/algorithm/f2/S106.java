package algorithm.f2;

public class S106 {
    public boolean isBipartite(int[][] graph) {
        // 二分图
        // 不会做，只知道并查集
        // 看了题解，可以用两倍大小的并查集，复制一组节点
        // 每次union的时候，分别和对方复制的节点连接，如果当前节点已经连上了，说明在同一个分组里面
        //   ----- A ------ DuplicateA ----
        //   ----- B ------ DuplicateB ----

        int len = graph.length;
        Graph g = new Graph(len * 2);
        for (int i = 0; i < len; i++) {
            int[] node = graph[i];
            for (int j = 0; j < node.length; j++) {
                if (g.connected(i, node[j])) {
                    return false;
                }
                g.union(i, node[j] + len);
                g.union(i + len, node[j]);
            }
        }
        return true;
    }

    class Graph {
        int[] root;
        int[] level;

        Graph(int n) {
            this.root = new int[n];
            this.level = new int[n];
            for (int i = 0; i < n; i++) {
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

        boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        void union(int x, int y) {
            int a = find(x);
            int b = find(y);
            if (a != b) {
                if (level[a] > level[b]) {
                    root[b] = root[a];
                } else if (level[a] == level[b]) {
                    root[b] = root[a];
                    level[a]++;
                } else {
                    root[a] = root[b];
                }
            }
        }
    }
}
