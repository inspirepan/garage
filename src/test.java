import Algorithm.*;
import DataStructure.ListNode;
import DataStructure.TreeNode;

import java.util.*;

public class test {
    public static void main(String[] args) {
        S102 s = new S102();
        TreeNode root = new TreeNode(-8,new TreeNode(-6),new TreeNode(7));
        System.out.println(s.levelOrder(root));
    }

    /* 输出二维数组 */
    public static void print(int[][] matrix) {
        for (int[] k : matrix)
            System.out.println(Arrays.toString(k));
    }

    /* 输出单链表 */
    public static void print(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}
