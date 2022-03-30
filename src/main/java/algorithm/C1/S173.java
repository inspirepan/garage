package algorithm.C1;

import datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class S173 {
    class BSTIterator {

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p;

        public BSTIterator(TreeNode root) {
            p = root;
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
        }

        public int next() {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            int val = p.val;
            p = p.right;
            return val;
        }

        public boolean hasNext() {
            return p != null || !stack.isEmpty();
        }
    }
}
