import java.util.ArrayList;
import java.util.Arrays;

import algorithm.S136;
import datastructure.ListNode;
import datastructure.Node;

public class test {
    public static void main(String[] args) {
        S136 s = new S136();
        System.out.println(s.singleNumber(new int[]{4,1,2,1,2}));

        /*Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors = new ArrayList<Node>(Arrays.asList(node2, node4));
        node2.neighbors = new ArrayList<Node>(Arrays.asList(node1, node3));
        node3.neighbors = new ArrayList<Node>(Arrays.asList(node2, node4));
        node4.neighbors = new ArrayList<Node>(Arrays.asList(node1, node3));*/

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
