package algorithm;

import datastructure.ListNode;

public class S206 {
    /**
     * 每次操作为
     * h
     * 1 -> 2 -> 3 -> 4
     * =>
     * h
     * 2 -> 1 -> 3 -> 4
     * =>
     * h
     * 3 -> 2 -> 1 -> 4
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head.next != null) {
            ListNode node = head.next;
            ListNode nxt = node.next;
            node.next = dummy.next;
            dummy.next = node;
            head.next = nxt;
            print(head);
        }
        return dummy.next;
    }

    /**
     * 每次操作为
     * p    c    n
     * 1 -> 2 -> 3 -> 4
     * =>
     * p    c    n
     * 1 <- 2    3 -> 4
     */
    public ListNode reverseList2(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            print(curr);
        }
        return prev;
    }


    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return last;
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