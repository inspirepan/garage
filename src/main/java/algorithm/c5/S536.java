package algorithm.c5;

import datastructure.TreeNode;
import java.util.Deque;
import java.util.LinkedList;

public class S536 {
    int index = 0;

    public TreeNode str2tree(String s) {
        // 可以递归
        // 试一试栈
        if (s.length() == 0) {
            return null;
        }
        int pos = s.indexOf("(");
        if (pos == -1) {
            return new TreeNode(Integer.parseInt(s));
        }
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, pos)));
        int start = pos;
        int count = 0;
        for (int i = pos; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            if (count == 0 && start == pos) {
                root.left = str2tree(s.substring(start + 1, i));
                start = i + 1;
            } else if (count == 0) {
                root.right = str2tree(s.substring(start + 1, i));
            }
        }
        return root;
    }

    public TreeNode str2tree2(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                stack.pop();
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) == '-') {
                int start = i;
                //找到根元素的值
                while (i < s.length() - 1 && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    i++;
                }
                TreeNode root = new TreeNode(Integer.parseInt(s.substring(start, i + 1)));
                //获取父节点
                if (!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    if (parent.left == null) {
                        parent.left = root;
                    } else {
                        parent.right = root;
                    }
                }

                //压栈
                stack.push(root);
            }
        }
        if (stack.isEmpty()) {
            return null;
        }
        return stack.peek();
    }
}
