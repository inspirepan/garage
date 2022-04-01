package algorithm.C7;

import java.util.HashSet;
import java.util.Set;

public class S769 {
    public int maxChunksToSorted(int[] arr) {
        // 将数组恢复成升序
        // 每个数字回到自己的位置，可以设置成一个对子
        // 这个对子中间的都算成一组
        // 然后并查集
        int len = arr.length;
        UnionFind uf = new UnionFind(len);
        for (int i = 0; i < arr.length; i++) {
            uf.groupUnion(i, arr[i]);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            System.out.println(uf.find(i));
            set.add(uf.find(i));
        }
        return set.size();
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

        void groupUnion(int left, int right) {
            int i = left + 1;
            while (i <= right) {
                union(left, i);
                i++;
            }
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
