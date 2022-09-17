package algorithm.c9;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : panjixiang
 * @since : 2022/9/17
 */
public class S947 {
    class Solution {
        public int removeStones(int[][] stones) {
            UnionFind uf = new UnionFind(20002);
            for (int[] stone : stones) {
                uf.union(stone[0], stone[1] + 10000);
            }
            Set<Integer> set = new HashSet<>();
            for (int[] stone : stones) {
                set.add(uf.findRoot(stone[0]));
            }

            return stones.length - set.size();
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

        int findRoot(int x) {
            while (root[x] != x) {
                root[x] = findRoot(root[x]);
                x = root[x];
            }
            return root[x];
        }

        void union(int x, int y) {
            int a = findRoot(x);
            int b = findRoot(y);
            if (height[a] > height[b]) {
                root[b] = a;
            } else {
                root[a] = b;
            }
        }


    }
}
