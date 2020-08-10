import java.util.Arrays;

import algorithm.S151;
import datastructure.ListNode;

public class test {
    public static void main(String[] args) {
        S151 s = new S151();
        System.out.println(s.reverseWords("the sky is blue"));
    }

    /* 输出二维数组 */
    public static void print(int[][] matrix) {
        for (int[] k : matrix)
            System.out.println(Arrays.toString(k));
    }

    /* 输出单链表 */
    public static void print(ListNode head) {
        ListNode ptr = head;
        if (ptr == null) {
            System.out.println("null");
            return;
        }
        while (ptr != null) {
            System.out.print(ptr.val + " ");
            ptr = ptr.next;
        }
        System.out.println(" ");
    }

}
