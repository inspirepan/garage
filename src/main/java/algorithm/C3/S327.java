package algorithm.C3;

import java.util.*;

public class S327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        // 头一次学线段树
        long sum = 0;
        // 先计算前缀和
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            preSum[i + 1] = sum;
        }

        Set<Long> allNumbers = new TreeSet<Long>();
        for (long x : preSum) {
            allNumbers.add(x);
            allNumbers.add(x - lower);
            allNumbers.add(x - upper);
        }
        // 利用哈希表进行离散化
        // TreeSet，全部数字按顺序放在values中
        Map<Long, Integer> values = new HashMap<Long, Integer>();
        int idx = 0;
        for (long x : allNumbers) {
            values.put(x, idx);
            idx++;
        }

        // 构建线段树
        SegNode root = build(0, values.size() - 1);
        int ret = 0;

        // 对于每一个前缀
        for (long x : preSum) {
            // 找到targetSum的上下限
            int left = values.get(x - upper), right = values.get(x - lower);
            // 使用线段树计算
            ret += count(root, left, right);
            // 将当前树插入到线段树中
            insert(root, values.get(x));
        }
        return ret;
    }

    // 可能出现的值
    public SegNode build(int left, int right) {
        SegNode node = new SegNode(left, right);
        if (left == right) {
            return node;
        }
        int mid = (left + right) / 2;
        node.lchild = build(left, mid);
        node.rchild = build(mid + 1, right);
        return node;
    }

    public int count(SegNode root, int left, int right) {
        // 如果不在这个区间内
        if (left > root.hi || right < root.lo) {
            return 0;
        }
        // 如果完全在这个区间内
        if (left <= root.lo && root.hi <= right) {
            return root.add;
        }
        // 找孩子区间
        return count(root.lchild, left, right) + count(root.rchild, left, right);
    }

    // 插入计数
    public void insert(SegNode root, int val) {
        root.add++;
        if (root.lo == root.hi) {
            return;
        }
        int mid = (root.lo + root.hi) / 2;
        if (val <= mid) {
            insert(root.lchild, val);
        } else {
            insert(root.rchild, val);
        }
    }

    class SegNode {
        int lo, hi, add;
        SegNode lchild, rchild;

        public SegNode(int left, int right) {
            lo = left;
            hi = right;
            add = 0;
            lchild = null;
            rchild = null;
        }
    }
}
