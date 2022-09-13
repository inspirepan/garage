package algorithm.C14;

import datastructure.TreeNode;
import java.util.HashSet;
import java.util.Set;

public class S1457 {

    private int count = 0;
    private final Set<Integer> set = new HashSet<>();

    public int pseudoPalindromicPaths(TreeNode root) {
        // 统计所有根节点到叶子节点的路径，然后判断每个路径是不是伪回文路径
        // 超时了T_T
        // 自己写的用统计判断伪回文的办法太蠢了
        // 可以用set，有就移除没有就添加，最后存在就是单数次
        // 看最后setSize是不是小于等于1就行了
        if (root == null) {
            return 0;
        }
        dfs(root);
        return count;
    }

    private void dfs(TreeNode node) {
        // node不应该为null
        // 添加node
        if (set.contains(node.val)) {
            set.remove(node.val);
        } else {
            set.add(node.val);
        }

        if (node.left == null && node.right == null) {
            if (set.size() <= 1) {
                count++;
            }
            if (set.contains(node.val)) {
                set.remove(node.val);
            } else {
                set.add(node.val);
            }
            return;
        }
        if (node.left != null) {
            dfs(node.left);
        }
        if (node.right != null) {
            dfs(node.right);
        }
        if (set.contains(node.val)) {
            set.remove(node.val);
        } else {
            set.add(node.val);
        }
    }
}
