package algorithm.c6;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S652 {
    // 比较树可以用序列化的方法
    Map<String, Integer> count = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return res;
    }

    public String serialize(TreeNode node) {
        if (node == null) {
            return "#";
        }
        String serial = node.val + "," +
                serialize(node.left) + "," + serialize(node.right);
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        if (count.get(serial) == 2) {
            res.add(node);
        }
        return serial;
    }
}
