package algorithm;

import datastructure.TreeNode;

public class S1448 {
    private int count = 0;

    public int goodNodes(TreeNode root) {
        // 统计从根节点到每个节点的最大值，然后和当前节点比较
        if (root != null) {
            helper(root, Integer.MIN_VALUE);
        }
        return count;
    }

    private void helper(TreeNode node, int max) {
        // node不应该为null
        if (node.val >= max) {
            count++;
        }
        if (node.left != null) {
            helper(node.left, Math.max(max, node.val));
        }
        if( node.right!=null){
            helper(node.right,Math.max(max,node.val));
        }
    }
}
