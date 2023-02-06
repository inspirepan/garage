package algorithm;

import datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class S1305 {

    class Solution {
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            List<Integer> res = new ArrayList<>();

            Deque<TreeNode> stack1 = new ArrayDeque<>();
            Deque<TreeNode> stack2 = new ArrayDeque<>();

            if (root1 == null && root2 == null) {
                return res;
            }
            TreeNode node1 = root1;
            TreeNode node2 = root2;
            while ((!stack1.isEmpty() || node1 != null) || (!stack2.isEmpty() || node2 != null)) {
                while (node1 != null) {
                    stack1.push(node1);
                    node1 = node1.left;
                }
                while (node2 != null) {
                    stack2.push(node2);
                    node2 = node2.left;
                }
                if (stack1.isEmpty()) {
                    node2 = stack2.pop();
                    res.add(node2.val);
                    node2 = node2.right;
                } else if (stack2.isEmpty()) {
                    node1 = stack1.pop();
                    res.add(node1.val);
                    node1 = node1.right;
                } else if (stack1.peek().val <= stack2.peek().val) {
                    node1 = stack1.pop();
                    res.add(node1.val);
                    node1 = node1.right;
                } else {
                    node2 = stack2.pop();
                    res.add(node2.val);
                    node2 = node2.right;
                }
            }
            return res;
        }
    }
}
