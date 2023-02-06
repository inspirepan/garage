package algorithm.c9;

import datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : panjixiang
 * @since : 2022/9/19
 */
public class S958 {
    class Solution {
        public boolean isCompleteTree(TreeNode root) {

            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            int level = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                int nextLevelSize = 0;
                boolean terminated = false;
                for (int i = 0; i < size; i++) {
                    var curr = queue.poll();
                    if (curr.left != null) {
                        if (terminated) {
                            return false;
                        }
                        queue.offer(curr.left);
                        nextLevelSize++;
                    } else {
                        terminated = true;
                    }
                    if (curr.right != null) {
                        if (terminated) {
                            return false;
                        }
                        queue.offer(curr.right);
                        nextLevelSize++;
                    } else {
                        terminated = true;
                    }
                }
                if (nextLevelSize != (1 << level)) {
                    for (int i = 0; i < nextLevelSize; i++) {
                        var node = queue.poll();
                        if (node.left != null || node.right != null) {
                            return false;
                        }
                    }
                }
                level++;
            }
            return true;
        }
    }
}
