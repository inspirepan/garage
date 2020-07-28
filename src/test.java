import algorithm.*;
import dataStructure.ListNode;
import dataStructure.TreeNode;

import java.util.*;

public class test {
    public static void main(String[] args) {
        S105 s = new S105();
        int[] pre = new int[] { 3, 9, 20, 15, 7 };
        int[] in = new int[] { 9, 3, 15, 20, 7 };
        TreeNode root = s.buildTree(pre, in);
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
