package algorithm.c6;

import datastructure.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class S653 {
    Set<Integer> record = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        return findTargetHelper(root, k);
    }

    private boolean findTargetHelper(TreeNode node, int k) {
        if (node == null) {
            return false;
        } else if (record.contains(node.val)) {
            return true;
        } else {
            record.add(k - node.val);
            return findTargetHelper(node.left, k) || findTargetHelper(node.right, k);
        }
    }
}
