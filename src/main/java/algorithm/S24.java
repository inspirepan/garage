package algorithm;

import datastructure.ListNode;

public class S24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dHead = new ListNode();
        dHead.next = head;
        ListNode p = dHead;
        while (p.next != null && p.next.next != null) {
            ListNode t = p.next; // t 0
            p.next = t.next;
            t.next = p.next.next;
            p.next.next = t;
            p = p.next.next;
        }
        return dHead.next;
    }
}
