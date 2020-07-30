package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import datastructure.TreeNode;

public class S107 {
    /* 二叉树从底部开始层次遍历 */
    /* 就是把102的结果反过来 */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null)
            return ans;
        LinkedList<TreeNode> queue = new LinkedList<>();
        int currentLevelCount = 0;
        queue.offer(root);
        currentLevelCount = queue.size();
        while (currentLevelCount != 0) {
            List<Integer> currentLevelResult = new ArrayList<>();
            for (int i = 0; i < currentLevelCount; i++) {
                TreeNode top = queue.pop();
                if (top.left != null)
                    queue.offer(top.left);
                if (top.right != null)
                    queue.offer(top.right);
                currentLevelResult.add(top.val);
            }
            currentLevelCount = queue.size();
            ans.addFirst(currentLevelResult);
        }
        return ans;
    }

}