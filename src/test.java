import Algorithm.*;
import DataStructure.ListNode;
import java.util.*;

public class test {
    public static void main(String[] args) {
        S1_3 s = new S1_3();
        System.out.println(s.lengthOfLongestSubstring("hello") + 23232);
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
