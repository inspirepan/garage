package algorithm.C6;

import datastructure.TreeNode;

import java.util.LinkedList;

// 自己写的
public class S662 {

    public int widthOfBinaryTreeWRONG(TreeNode root) {
        //二叉树层序遍历 空节点用null加入列表，然后计算每一行的长度，会超时！！
        if (root == null) return 0;
        LinkedList<TreeNode> curr = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        curr.offer(root);
        int maxLen = 0;
        boolean hasNext = true;

        while (hasNext && (!curr.isEmpty() || !next.isEmpty())) {
            if (curr.isEmpty()) {
                curr = new LinkedList<>(next);
                printlist(curr);
                printlist(next);
                int len = getLen(next);
                System.out.println(len);
                hasNext = len == 0;
                maxLen = Math.max(maxLen, len);
                next.clear();
            } else {
                TreeNode node = curr.poll();
                if (node == null) {
                    next.offer(null);
                    next.offer(null);
                } else {
                    next.offer(node.left);
                    next.offer(node.right);
                }
            }
        }
        return maxLen;
    }

    int getLen(LinkedList<TreeNode> queue) {
        if (queue.isEmpty()) return 0;
        while (!queue.isEmpty() && queue.getFirst() == null) {
            queue.pollFirst();
        }
        while (!queue.isEmpty() && queue.getLast() == null) {
            queue.pollLast();
        }
        return queue.size();
    }

    void printlist(LinkedList<TreeNode> list) {
        for (TreeNode treeNode : list) {
            if (treeNode == null) System.out.print("null ");
            else System.out.print(treeNode.val + " ");
        }
        System.out.println("  ");
    }
}
