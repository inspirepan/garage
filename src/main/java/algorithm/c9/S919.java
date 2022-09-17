package algorithm.c9;

import datastructure.TreeNode;
import java.util.ArrayList;

/**
 * @author : panjixiang
 * @since : 2022/9/17
 */
public class S919 {
    class CBTInserter {
        TreeNode root;
        ArrayList<TreeNode> lastFullRow;

        public CBTInserter(TreeNode root) {
            this.root = root;
            var list = new ArrayList<TreeNode>();
            list.add(root);
            while (list.size() > 0) {
                var nextRow = new ArrayList<TreeNode>();
                for (TreeNode treeNode : list) {
                    if (treeNode.left == null) {
                        lastFullRow = list;
                        return;
                    } else {
                        nextRow.add(treeNode.left);
                    }
                    if (treeNode.right == null) {
                        lastFullRow = list;
                        return;
                    } else {
                        nextRow.add(treeNode.right);
                    }
                }
                list = nextRow;
            }
        }

        public int insert(int val) {
            var list = new ArrayList<TreeNode>();
            for (int i = 0; i < lastFullRow.size(); i++) {
                var node = lastFullRow.get(i);
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return node.val;
                } else if (node.right == null) {
                    node.right = new TreeNode(val);
                    list.add(node.left);
                    list.add(node.right);
                    if (i == lastFullRow.size() - 1) {
                        lastFullRow = list;
                    }
                    return node.val;
                }
                list.add(node.left);
                list.add(node.right);
            }
            return -1;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
