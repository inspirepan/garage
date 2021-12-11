package algorithm.S101to200;

import java.util.LinkedList;
import java.util.List;

import datastructure.TreeNode;

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

    private void dfs(TreeNode root, int currentSum) {
        if (root.left == null && root.right == null) {
            if (currentSum + root.val == sum) {
                singleResult.add(root.val);
                /* 这里要用深拷贝！！ */
                LinkedList<Integer> copy = new LinkedList<Integer>(singleResult);
                pathSumResult.add(copy);
                singleResult.removeLast();
            }
        } else {
            singleResult.add(root.val);
            if (root.left != null)
                dfs(root.left, currentSum + root.val);
            if (root.right != null)
                dfs(root.right, currentSum + root.val);
            singleResult.removeLast();
        }
    }
}