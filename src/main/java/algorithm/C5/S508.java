package algorithm.C5;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S508 {
    // sum -> times
    Map<Integer, Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        // 统计每个节点的元素和，要用一个结构记录每个元素的出现次数
        if (root == null) return new int[0];
        helper(root);
        int max = 0;
        List<Integer> result = new ArrayList<>();
        // 其实可以在helper里面统计max
        for (int times : map.values()) max = Math.max(max, times);
        for (var entry : map.entrySet()) {
            if (entry.getValue() == max) result.add(entry.getKey());
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    int helper(TreeNode node) {
        // return the sum of this node
        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
            return node.val;
        }
        int sum = node.val + helper(node.left) + helper(node.right);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
