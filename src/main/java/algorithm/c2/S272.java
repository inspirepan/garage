package algorithm.c2;

import datastructure.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class S272 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        dfs(root, list, k, target);
        // 有序列表找k个最接近的值
        int i = 0;
        return list;
    }

    void dfs(TreeNode node, LinkedList<Integer> list, int k, double target) {
        if (node.left != null) {
            dfs(node.left, list, k, target);
        }
        if (list.size() < k) {
            list.add(node.val);
        } else if (Math.abs(list.get(0) - target) > Math.abs(node.val - target)) {
            list.pollFirst();
            list.add(node.val);
        }
        if (node.right != null) {
            dfs(node.right, list, k, target);
        }
    }
}
