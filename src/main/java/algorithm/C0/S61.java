package algorithm.C0;

import datastructure.ListNode;

public class S61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null || k == 0) {
            return head;
        }
        ListNode fast = new ListNode(0);
        ListNode slow = fast;
        ListNode dummy = slow;
        fast.next = head;
        int t = k;
        int count = 0;
        while (t-- > 0) {
            if (fast.next == null) {
                t = k % count;
                fast = slow;
            } else {
                fast = fast.next;
                count++;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (slow == dummy) {
            return head;
        }

        fast.next = head;
        ListNode newHead = slow.next;
        slow.next = null;
        return newHead;
    }
}
