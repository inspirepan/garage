package algorithm;

import datastructure.ListNode;

public class S86 {
    public ListNode partition(ListNode head, int x) {
        ListNode lower = new ListNode(0);
        ListNode dummyLower = lower;
        ListNode greater = new ListNode(0);
        ListNode dummyGreater = greater;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                lower.next = p;
                lower = p;
            } else {
                greater.next = p;
                greater = p;
            }
            p = p.next;
        }
        greater.next = null;
        lower.next = dummyGreater.next;
        return dummyLower.next;
    }
}
