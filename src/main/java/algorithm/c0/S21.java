package algorithm.c0;

import datastructure.ListNode;

public class S21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode d = new ListNode();
        ListNode p = d;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            } else if (l2 == null) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            } else {
                if (l1.val > l2.val) {
                    p.next = l2;
                    l2 = l2.next;
                } else {
                    p.next = l1;
                    l1 = l1.next;
                }
                p = p.next;
            }
        }
        return d.next;
    }
}
