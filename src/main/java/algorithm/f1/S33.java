package algorithm.f1;

public class S33 {
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    private boolean helper(int[] postorder, int start, int end) {
        // 最后一个数是root
        if (start >= end) {
            return true;
        }
        int rootVal = postorder[end];
        int p = start;
        int q = end - 1;
        while (p < end && postorder[p] < rootVal) {
            p++;
        }
        while (q >= start && postorder[q] > rootVal) {
            q--;
        }
        if (p != q + 1) {
            return false;
        }
        // 左子树和右子树都是
        return helper(postorder, start, p - 1) && helper(postorder, q + 1, end - 1);
    }
}
