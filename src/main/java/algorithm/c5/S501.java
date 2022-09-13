package algorithm.c5;

import datastructure.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class S501 {
    public int[] findMode(TreeNode root) {
        // 不能用额外的空间，用递归就好了，用自己的栈慢很多
        // 差点忘了是BST
        if (root == null) {
            return new int[] {0};
        }
        List<Integer> res = new ArrayList<>();
        int times = 0;
        int currTimes = 0;
        int currVal = root.val;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            // inOrder
            if (node.val == currVal) {
                if (++currTimes > times) {
                    res.clear();
                    res.add(currVal);
                    times = currTimes;
                } else if (currTimes == times) {
                    res.add(currVal);
                }
            } else {
                currVal = node.val;
                currTimes = 1;
                // newValue
                if (currTimes > times) {
                    res.clear();
                    res.add(currVal);
                    times = currTimes;
                } else if (currTimes == times) {
                    res.add(currVal);
                }
            }
            node = node.right;
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
