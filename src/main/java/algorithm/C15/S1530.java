package algorithm.C15;

import datastructure.TreeNode;

import java.util.Arrays;

public class S1530 {

    private int count = 0;
    private int distance;

    public int countPairs(TreeNode root, int distance) {
        // 常规通过递归解决二叉树问题的方法好像不管用
        // 等一下，必须要叶子节点之间啊
        // 那就简单一些了
        if (distance <= 1) {
            return 0;
        }
        this.distance = distance;
        // 递归的话，就等于左边子树、右边子树+新的左右子树各一个叶子节点组成的好叶子对数量，可以在递归时向上传一个各个层数的叶子节点的数量
        // System.out.println(Arrays.toString(dfs(root)));
        dfs(root);
        return count;
    }

    private int[] dfs(TreeNode root) {
        // 返回结果是当前节点各深度的叶子节点数量
        // 最大深度只需要到distance就可以了
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            // 叶子0层是1
            int[] arr = new int[distance];
            arr[0] = 1;
            return arr;
        }
        if (root.left == null || root.right == null) {
            int[] arr = root.left == null ? dfs(root.right) : dfs(root.left);
            // 层数+1
            int[] newArr = new int[distance];
            System.arraycopy(arr, 0, newArr, 1, distance - 1);
            return newArr;
        }
        int[] leftArr = dfs(root.left);
        int[] rightArr = dfs(root.right);
        // 这是子节点的，没有考虑到根节点各需要+1；
        // left和right也可能是叶子节点！i和j要从0开始遍历
        for (int i = 0; i <= distance - 2; i++) {
            for (int j = 0; j <= distance - i - 2; j++) {
                // 保证i+j+2<=distance
                count += leftArr[i] * rightArr[j];
            }
        }
        // 生成当前节点的层数信息
        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] += rightArr[i];
        }
        System.arraycopy(leftArr, 0, rightArr, 1, distance - 1);
        rightArr[0] = 0;
        return rightArr;
    }
}
