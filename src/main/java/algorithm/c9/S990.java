package algorithm.c9;

import java.util.Arrays;

/**
 * @author : panjixiang
 * @since : 2022/11/11
 */
public class S990 {
    class Solution {
        public boolean equationsPossible(String[] equations) {
            var uf = new UnionFind(26);
            //  deal with equal first
            for (String equation : equations) {
                int c1 = equation.charAt(0) - 'a';
                int c2 = equation.charAt(3) - 'a';
                if (equation.charAt(1) == '=') {
                    uf.union(c1, c2);
                }
            }
            // deal with not equal
            for (String equation : equations) {
                int c1 = equation.charAt(0) - 'a';
                int c2 = equation.charAt(3) - 'a';
                if (equation.charAt(1) == '!') {
                    if (uf.findRoot(c1) == uf.findRoot(c2)) {
                        return false;
                    }
                }
            }
            System.out.println(Arrays.toString(uf.root));
            return true;
        }
    }

    class UnionFind {
        int[] size;
        int[] root;
        int maxSize = 1;

        UnionFind(int N) {
            this.size = new int[N];
            this.root = new int[N];
            for (int i = 0; i < N; i++) {
                root[i] = i;
            }
            Arrays.fill(size, 1);
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
            if (a != b) {
                root[b] = a;
                size[a] += size[b];
                maxSize = Math.max(maxSize, size[a]);
            }
        }
    }
}
