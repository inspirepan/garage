package algorithm.C0;

import datastructure.ListNode;

public class S82 {
    /**
     * a conciser version
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode();
        ListNode p = head;
        ListNode q = dummyHead;
        dummyHead.next = head;

        while (p.next != null) {
            if (p.next.val != p.val) {
                q = q.next;
            } else {
                while (p.next != null && p.next.val == p.val) {
                    p = p.next;
                }
                q.next = p.next;
                if (p.next == null) {
                    return dummyHead.next;
                }
            }
            p = p.next;
        }
        return dummyHead.next;
    }
}
