package algorithm.c4;

public class S421 {
    TrieNode root = new TrieNode();

    public int findMaximumXOR(int[] nums) {
        //  110
        //  001
        //  100
        // 两个数不同的位置最多
        // 还是字典树，第一轮遍历用来构建字典树
        // 第二轮遍历用来针对每一个数扫字典树，
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 0;
        }
        root = new TrieNode();
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            insert(nums[i - 1]);
            max = Math.max(max, find(nums[i]));
        }
        return max;
    }

    private void insert(int n) {
        int i = 31;
        TrieNode p = root;
        while (i-- > 0) {
            int bit = (n >> i) & 1;
            if (bit == 1) {
                if (p.right == null) {
                    p.right = new TrieNode();
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new TrieNode();
                }
                p = p.left;
            }
        }
    }

    private int find(int n) {
        int i = 31;
        int x = 0;
        TrieNode p = root;
        while (i-- > 0) {
            x <<= 1;
            int bit = (n >> i) & 1;
            if (bit == 0) {
                if (p.right != null) {
                    p = p.right;
                    x++;
                } else {
                    p = p.left;
                }
            } else {
                if (p.left != null) {
                    p = p.left;
                    x++;
                } else {
                    p = p.right;
                }
            }
        }
        return x;
    }

    private class TrieNode {
        TrieNode left; // 0
        TrieNode right; // 1
    }
}