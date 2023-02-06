package algorithm.c6;

import datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class S663 {
    // 其实可以不用Map，单独把总和为0的次数拎出来就可以了
    Map<Integer, Integer> map = new HashMap<>();

    public boolean checkEqualTree(TreeNode root) {
        // 记录每个节点的子树和，如果整个树的和除以二出现过，就是true
        if (root == null) {
            return false;
        }
        int sum = getSum(root);
        // 特殊情况是0
        if (sum == 0) {
            return map.get(0) >= 2;
        }
        return (sum & 1) == 0 && map.containsKey(sum / 2);
    }

    private int getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int temp = node.val + getSum(node.left) + getSum(node.right);
        map.put(temp, map.getOrDefault(temp, 0) + 1);
        return temp;
    }
}
