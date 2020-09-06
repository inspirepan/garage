package algorithm;

import datastructure.TreeNode;

import java.util.*;

/**
 * 二叉树相关的题目
 *
 * @author panjx
 */
public class BinaryTree {
    /**
     * 102 层序遍历二叉树
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        // 用ArrayDeque慢好多
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currCount = 1;
        while (currCount != 0) {
            var currLevel = new ArrayList<Integer>();
            for (int i = 0; i < currCount; i++) {
                var node = queue.pop();
                currLevel.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            currCount = queue.size();
            result.add(currLevel);
        }
        return result;
    }

    /**
     * 107 反相层序遍历
     * 把层向遍历的结果翻过来
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result;
        Collections.reverse(result = levelOrder(root));
        return result;
    }
}
