import Algorithm.*;
import DataStructure.ListNode;

import java.util.*;

public class test {
    public static void main(String[] args) {
        S93 s = new S93();
        System.out.println(s.restoreIpAddresses("2552552551"));
    }

    public static void printIntegerMatrix(int[][] matrix) {
        for (int[] k : matrix) System.out.println(Arrays.toString(k));
    }

    public static void printLinkList(ListNode head) {
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


