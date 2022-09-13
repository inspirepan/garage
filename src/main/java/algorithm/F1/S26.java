package algorithm.F1;

import datastructure.TreeNode;

public class S26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 之所以要一个helper，是因为B==null应该是一个true的匹配条件，但是不能在最外层参数B这里取空
        if (A == null || B == null) {
            return false;
        }
        if (helper(A, B)) {
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean helper(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val == B.val) {
            return helper(A.left, B.left) && helper(A.right, B.right);
        }
        return false;
    }
}
