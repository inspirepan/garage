package algorithm.O2;

import datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class S32II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int nextLevel = 0;
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    nextLevel++;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    nextLevel++;
                    queue.offer(node.right);
                }
            }
            list.add(levelList);
            level = nextLevel;
        }
        return list;
    }
}
