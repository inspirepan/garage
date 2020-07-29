package algorithm;

import java.util.LinkedList;
import java.util.List;

import dataStructure.TreeNode;

public class S113 {
    private LinkedList<Integer> singleResult;
    private List<List<Integer>> pathSumResult;
    private int sum;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        pathSumResult = new LinkedList<List<Integer>>();
        singleResult = new LinkedList<Integer>();
        if (root == null)
            return pathSumResult;
        this.dfs(root, 0);
        return pathSumResult;
    }

    private boolean dfs(TreeNode root, int currentSum) {
        if (root.left == null && root.right == null) {
            if (currentSum + root.val == sum) {
                singleResult.add(root.val);
                /* 这里要用深拷贝！！ */
                LinkedList<Integer> copy = new LinkedList<Integer>();
                copy.addAll(singleResult);
                pathSumResult.add(copy);
                singleResult.removeLast();
                return true;
            } else {
                return false;
            }
        } else if (root.left == null) {
            singleResult.add(root.val);
            if (dfs(root.right, currentSum + root.val)) {
                singleResult.removeLast();
                return true;
            } else {
                singleResult.removeLast();
                return false;
            }
        } else if (root.right == null) {
            singleResult.add(root.val);
            if (dfs(root.left, currentSum + root.val)) {
                singleResult.removeLast();
                return true;
            } else {
                singleResult.removeLast();
                return false;
            }
        } else {
            singleResult.add(root.val);
            /* 这里一开始用了阻塞的||，导致只求出一个结果诶 */
            if (dfs(root.left, currentSum + root.val) | dfs(root.right, currentSum + root.val)) {
                singleResult.removeLast();
                return true;
            } else {
                singleResult.removeLast();
                return false;
            }
        }
    }
}