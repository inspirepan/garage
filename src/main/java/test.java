import java.util.Arrays;

import algorithm.*;
import datastructure.ListNode;

public class test {
    public static void main(String[] args) {
        S128 s = new S128();
        System.out.println(s.longestConsecutive(new int[]{1,2,0,1}));
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
