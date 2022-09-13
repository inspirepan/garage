package algorithm.c8;

import datastructure.ListNode;

public class S876 {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode low = head;
        do {
            fast = fast.next.next;
            low = low.next;

        } while (fast != null && fast.next != null);
        return low;
    }
}