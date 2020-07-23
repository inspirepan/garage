package Algorithm;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S94 {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        } else {
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);
        }
        return result;
    }


}
