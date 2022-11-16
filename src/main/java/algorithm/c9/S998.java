package algorithm.c9;

import datastructure.TreeNode;

/**
 * @author : panjixiang
 * @since : 2022/11/15
 */
public class S998 {
    class Solution {
        public TreeNode insertIntoMaxTree(TreeNode root, int val) {
            // root给出的树是按照一定的规则从数组给出的
            // 然后将val加入到末尾，重新按这个规则生成树

            // 或者是分析，其实将整个树拍平了就是这个数组，现在在末尾加入一个新节点，找到对应高度就可以了
            // 由于新的节点一定是最右边，所以我们val一定是父节点的右子节点，它的子节点一定是左子节点

            if (root == null) {
                return new TreeNode(val);
            }

            if (root.val < val) {
                var nn = new TreeNode(val);
                nn.left = root;
                return nn;
            }

            if (root.right == null) {
                root.right = new TreeNode(val);
                return root;
            }

            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
    }
}
