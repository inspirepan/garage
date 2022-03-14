package algorithm.C5;

import datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class S538 {
    public TreeNode convertBST(TreeNode root) {
        // 中序遍历，大于等于
        int sum = 0;
        TreeNode node = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<TreeNode> list = new ArrayList<>();
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node);
            node = node.right;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            var n = list.get(i);
            sum += n.val;
            n.val = sum;
        }
        return root;
    }
}
