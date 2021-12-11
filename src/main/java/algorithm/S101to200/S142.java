package algorithm.S101to200;

import datastructure.ListNode;

public class S142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while (head != fast) {
                    head = head.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }
}