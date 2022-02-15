package algorithm.C0;

import datastructure.ListNode;

public class S92 {

    /**
     * 反转链表2
     *
     *  12345
     *  21345
     *  32145
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode p = dummyHead;
        for (int i = 1; i < m; i++) {
            p = p.next;
        }
        // reverse node after p
        ListNode q = p.next;
        for (int i = m; i < n; i++) {
            ListNode nxt = q.next;
            q.next = nxt.next;
            nxt.next = p.next;
            p.next = nxt;
        }
        return dummyHead.next;
    }
}