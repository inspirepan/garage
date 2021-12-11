package algorithm.S201to300;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import datastructure.TreeNode;

public class S297 {
    public class Codec {
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            LinkedList<String> result = new LinkedList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode node = root;
            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    stack.push(node);
                    result.offer(Integer.toString(node.val));
                    node = node.left;
                }
                result.offer("#");
                node = stack.pop();
                node = node.right;
            }
            result.offer("#"); // 关键是这里，前序遍历到最后一个会打止，因此最后一个叶子结点少了一个右空孩子的「#」标志
            sb.append("\"[").append(String.join(",", result)).append("]\"");
            return sb.toString();

        }

        /* 迭代的不会，只会递归混混日子 */
        public TreeNode deserialize(String data) {
            String trimData = data.substring(2, data.length() - 2);
            String[] dataArray = trimData.split(",");
            return deserializeHelper(new LinkedList<String>(Arrays.asList(dataArray)));
        }

        private TreeNode deserializeHelper(LinkedList<String> list) {
            String nodeString;
            if ((nodeString = list.remove()).equals("#")) {
                return null;
            } else {
                TreeNode root = new TreeNode(Integer.parseInt(nodeString));
                root.left = deserializeHelper(list);
                root.right = deserializeHelper(list);
                return root;
            }
        }


    }
}