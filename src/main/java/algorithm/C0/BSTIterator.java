package algorithm.C0;

import datastructure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class BSTIterator {
    private Deque<TreeNode> stack = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode t = stack.pop();
        int val = t.val;
        t = t.right;
        while (t != null) {
            stack.push(t);
            t = t.left;
        }
        return val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
