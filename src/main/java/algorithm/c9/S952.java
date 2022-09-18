package algorithm.c9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : panjixiang
 * @since : 2022/9/18
 */
public class S952 {

    class Solution {
        void add(Map<Integer, List<Integer>> map, int key, int val) {
            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
            list.add(val);
            map.put(key, list);
        }


        public int largestComponentSize(int[] nums) {
            // 判断是否连接的方法要优化，不能每次gcd，效率很低
            UnionFind uf = new UnionFind(nums.length);
            var map = new HashMap<Integer, List<Integer>>();
            for (int i = 0; i < nums.length; i++) {
                int cur = nums[i];
                for (int j = 2; j * j <= cur; j++) {
                    if (cur % j == 0) {
                        add(map, j, i);
                    }
                    while (cur % j == 0) {
                        cur /= j;
                    }
                }
                if (cur > 1) {
                    add(map, cur, i);
                }
            }
            for (var e : map.entrySet()) {
                var list = e.getValue();
                for (int i = 1; i < list.size(); i++) {
                    uf.union(list.get(i), list.get(0));
                }
            }
            return uf.maxSize;
        }

        int gcd(int a, int b) {
            int r;
            while (b > 0) {
                r = a % b;
                a = b;
                b = r;
            }
            return a;
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
