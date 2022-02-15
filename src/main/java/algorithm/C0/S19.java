package algorithm.C0;

import datastructure.ListNode;

public class S19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = new ListNode(0);
        fast.next = head;
        ListNode d = fast;
        ListNode slow = fast;
        while (fast != null) {
            fast = fast.next;
            if (n == -1) {
                slow = slow.next;
            }
            if (n > -1) {
                n--;
            }
        }
        slow.next = slow.next.next;
        return d.next;
    }
}
