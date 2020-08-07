import java.util.ArrayList;
import java.util.Arrays;

import algorithm.S147;
import datastructure.LinkList;
import datastructure.ListNode;

public class test {
    public static void main(String[] args) {
        S147 s = new S147();
        LinkList l = new LinkList(new int[] {  4,3,2,6,1 });
        print(s.insertionSortList(l.headNode));
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
