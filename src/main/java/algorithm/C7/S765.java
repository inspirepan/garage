package algorithm.C7;

import java.util.Arrays;

public class S765 {
    public int minSwapsCouples(int[] row) {
        int n = row.length / 2;
        // 怎么用图去做
        // 用并查集分组，就是说n组情侣完全错乱在n组座位中，需要交换n-1次
        // 也就是总交换次数是：n-组数
        int[][] couples = new int[n][2];
        for (int[] couple : couples) {
            Arrays.fill(couple, -1);
        }
        for (int i = 0; i < n; i++) {
            int first = row[i << 1] >>> 1;
            int second = row[(i << 1) + 1] >>> 1;
            if (couples[first][0] == -1) {
                couples[first][0] = i;
            } else {
                couples[first][1] = i;
            }
            if (couples[second][0] == -1) {
                couples[second][0] = i;
            } else {
                couples[second][1] = i;
            }
        }
        UnionFind uf = new UnionFind(n);
        for (int[] couple : couples) {
            uf.union(couple[0], couple[1]);
        }

        return n - uf.groups;
    }

    class UnionFind {
        int[] root;
        int groups;

        UnionFind(int n) {
            // 将n组座位分成几个大组
            this.root = new int[n];
            groups = n;
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

        void union(int x, int y) {
            int a = find(x);
            int b = find(y);
            if (a != b) {
                groups--;
                root[a] = b;
            }
        }
    }
}