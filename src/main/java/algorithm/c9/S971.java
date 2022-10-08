package algorithm.c9;

import datastructure.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : panjixiang
 * @since : 2022/9/27
 */
public class S971 {
    class Solution {
        List<Integer> revert = new ArrayList<>();

        public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
            return helper(root, 0, voyage.length - 1, voyage) ? revert : List.of(-1);
        }

        boolean helper(TreeNode node, int left, int right, int[] voyage) {
            if (node.val != voyage[left]) {
                return false;
            }
            if (node.left == null && node.right == null) {
                return left == right;
            }
            if (node.left == null) {
                return node.right.val == voyage[left + 1] && helper(node.right, left + 1, right, voyage);
            }
            if (node.right == null) {
                return node.left.val == voyage[left + 1] && helper(node.left, left + 1, right, voyage);
            }

            if (node.left.val == voyage[left + 1]) {
                int idx = findIndex(voyage, node.right.val, left + 1, right);
                if (idx == -1) {
                    return false;
                }
                return helper(node.left, left + 1, idx - 1, voyage) && helper(node.right, idx, right, voyage);
            }
            int idx = findIndex(voyage, node.left.val, left + 1, right);
            if (idx == -1) {
                return false;
            }
            revert.add(node.val);
            return helper(node.right, left + 1, idx - 1, voyage) && helper(node.left, idx, right, voyage);
        }

        int findIndex(int[] voyage, int val, int left, int right) {
            for (int i = left; i <= right; i++) {
                if (voyage[i] == val) {
                    return i;
                }
            }
            return -1;
        }
    }
}
