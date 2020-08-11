import java.util.Arrays;
import java.util.Collections;

import algorithm.S151;
import algorithm.S152;
import datastructure.ListNode;

public class test {
    public static void main(String[] args) {
        S152 s = new S152();
        System.out.println(s.maxProduct(new int[]{0,2}));
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
