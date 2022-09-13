package algorithm.c3;

import java.util.ArrayList;
import java.util.List;

public class S305 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        // 这样子也超时了，并查集应该没问题，就是统计岛屿数量的时候有问题
        // 优化一下，每次加入一个陆地的时候count++，然后再union的时候减1
        // 并查集，每次加入陆地后，将四周的union在一起
        UnionFind uf = new UnionFind(m * n);
        List<Integer> result = new ArrayList<>();
        int[] dx = new int[] {-1, 0, 0, 1};
        int[] dy = new int[] {0, -1, 1, 0};
        boolean[] isLand = new boolean[m * n];
        for (int[] pos : positions) {
            int curr = pos[0] * n + pos[1];
            if (isLand[curr]) {
                result.add(uf.getCount());
                continue;
            }
            uf.addCount();
            //如果四周有陆地，把它们连起来
            for (int i = 0; i < 4; i++) {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                int next = nx * n + ny;
                // 注意不要重复union，不然count会出错
                if (isLand[next] && !uf.isConnected(curr, next)) {
                    uf.union(next, curr);
                }
            }
            // 找当前有多少陆地
            isLand[curr] = true;
            result.add(uf.getCount());
        }
        return result;
    }

    class UnionFind {
        int[] root;
        int[] height;
        int count;

        UnionFind(int n) {
            this.root = new int[n];
            this.height = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
            count = 0;
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
            count--;
        }

        boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        int getCount() {
            return count;
        }

        void addCount() {
            count++;
        }
    }
}
