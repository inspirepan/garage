package algorithm.c8;

/**
 * @author : panjixiang
 * @since : 2022/10/16
 */
public class S886 {
    class Solution {
        public boolean possibleBipartition(int n, int[][] dislikes) {
            // 如果有三个人互相之间都不喜欢 就不行
            UnionFind uf = new UnionFind(n * 2 + 2);
            for (int[] dislike : dislikes) {
                if (uf.find(dislike[0]) == uf.find(dislike[1])) {
                    return false;
                }
                uf.union(dislike[0], dislike[1] + n);
                uf.union(dislike[1], dislike[0] + n);
            }
            return true;
        }
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
