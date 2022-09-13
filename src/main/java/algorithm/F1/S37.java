package algorithm.F1;

import datastructure.TreeNode;

public class S37 {

    public class Codec {

        public String serialize(TreeNode root) {
            if (root == null) {
                return "#";
            }
            return new StringBuilder().append(root.val).append("(").append(serialize(root.left))
                .append(",").append(serialize(root.right)).append(")").toString();
        }

        public TreeNode deserialize(String data) {
            System.out.println(data);
            // 反序列化比较难诶
            if (data.equals("#")) {
                return null;
            }
            if (!data.contains("(")) {
                return new TreeNode(Integer.parseInt(data));
            }
            int left = data.indexOf("(");
            TreeNode root = new TreeNode(Integer.parseInt(data.substring(0, left)));
            // 找到中间的分割逗号
            int p = left + 1;
            int leftCount = 1;
            while (p < data.length()) {
                char c = data.charAt(p);
                if (c == ',') {
                    if (leftCount == 1) {
                        // 找到了分隔的逗号
                        root.left = deserialize(data.substring(left + 1, p));
                        root.right = deserialize(data.substring(p + 1, data.length() - 1));
                        break;
                    }
                } else if (c == '(') {
                    leftCount++;
                } else if (c == ')') {
                    leftCount--;
                }
                p++;
            }
            return root;
        }
    }
}
