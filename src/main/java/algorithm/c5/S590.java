package algorithm.c5;

import datastructure.Node;
import java.util.ArrayList;
import java.util.List;

public class S590 {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }
        if (node.children != null) {
            for (Node child : node.children) {
                helper(child, res);
            }
        }
        res.add(node.val);
    }
}
