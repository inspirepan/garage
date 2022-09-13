package algorithm.F1;

import datastructure.ListNode;

public class S52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = 0;
        int lenB = 0;
        ListNode dummyA = new ListNode();
        ListNode dummyB = new ListNode();
        ListNode p = dummyA;
        ListNode q = dummyB;
        p.next = headA;
        q.next = headB;
        while (p.next != null) {
            p = p.next;
            lenA++;
        }
        while (q.next != null) {
            q = q.next;
            lenB++;
        }
        p = dummyA;
        q = dummyB;
        if (lenA > lenB) {
            int t = lenA - lenB;
            while (t-- > 0) {
                p = p.next;
            }
        } else if (lenB > lenA) {
            int t = lenB - lenA;
            while (t-- > 0) {
                q = q.next;
            }
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
            if (p == q) {
                return p;
            }
        }
        return null;
    }
}
