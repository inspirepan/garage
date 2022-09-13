package algorithm.c8;

import java.util.HashSet;
import java.util.Set;

public class S839 {
    public int numSimilarGroups(String[] strs) {
        // 看错题目了，还以为是要怎么样快速判断相似，原来是要根据相似分成几个大组啊
        // 那就是标准的并查集题目了
        int len = strs.length;
        UnionFind uf = new UnionFind(len);
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    uf.union(i, j);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(uf.find(i));
        }
        return set.size();
    }

    private boolean isSimilar(String str1, String str2) {
        int diff = 0;
        char t1 = '0';
        char t2 = '0';
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (c1 != c2) {
                if (0 == diff) {
                    t1 = c1;
                    t2 = c2;
                    diff = 1;
                } else if (1 == diff) {
                    // 错位
                    if (t1 != c2 || t2 != c1) {
                        return false;
                    }
                    diff++;
                } else if (2 == diff) {
                    return false;
                }
            }
        }
        return diff == 2 || diff == 0;
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
