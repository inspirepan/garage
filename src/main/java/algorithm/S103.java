package algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import datastructure.TreeNode;

public class S103 {
    /* 锯齿状层序遍历 */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        int currentLevelCount;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null)
            return ans;
        ans.add(new ArrayList<>(Collections.singletonList(root.val)));
        queue.add(root);
        currentLevelCount = queue.size();
        boolean rotation = true;
        while (currentLevelCount != 0) {
            List<Integer> currentLevelResult = new ArrayList<>();
            if (rotation) {
                for (int i = 0; i < currentLevelCount; i++) {
                    TreeNode top = queue.pollFirst();
                    if (top.left != null)
                        queue.addLast(top.left);
                    if (top.right != null)
                        queue.addLast(top.right);
                    currentLevelResult.add(top.val);
                }
            } else {
                for (int i = 0; i < currentLevelCount; i++) {
                    TreeNode top = queue.pollLast();
                    if (top.right != null)
                        queue.addFirst(top.right);
                    if (top.left != null)
                        queue.addFirst(top.left);
                    currentLevelResult.add(top.val);
                }
            }
            ans.add(currentLevelResult);
            currentLevelCount = queue.size();
            rotation = !rotation;
        }
        ans.remove(0);
        return ans;
    }
}