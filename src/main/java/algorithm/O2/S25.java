package algorithm.O2;

import datastructure.ListNode;

public class S25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode p = l1;
        ListNode q = l2;
        ListNode t = dummy;
        while (p != null || q != null) {
            if (p == null) {
                t.next = q;
                q = q.next;
            } else if (q == null) {
                t.next = p;
                p = p.next;
            } else if (p.val >= q.val) {
                t.next = q;
                q = q.next;
            } else {
                t.next = p;
                p = p.next;
            }
            t = t.next;
        }
        return dummy.next;
    }
}
