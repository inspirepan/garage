package algorithm.c9;

import datastructure.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : panjixiang
 * @since : 2022/9/17
 */
public class S938 {
    class Solution {
        public int rangeSumBST(TreeNode root, int low, int high) {
            // 真的快忘了，写不出来了
            int res = 0;
            Deque<TreeNode> stack = new ArrayDeque<>();
            var node = root;
            while (!stack.isEmpty() || node != null) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                if (node.val >= low && node.val <= high) {
                    res += node.val;
                }
                node = node.right;
            }
            return res;
        }

    }
}
