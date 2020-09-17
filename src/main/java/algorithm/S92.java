package algorithm;

import datastructure.ListNode;

public class S92 {

    /**
     * 反转链表2
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode p = dummyHead;
        for (int i = 1; i < m; i++) {
            p = p.next;
        }
        ListNode q = p.next;
        for (int i = m; i < n; i++) {
            // 将q的next插入到p后面
            ListNode nxt = q.next;
            q.next = nxt.next;
            nxt.next = p.next;
            p.next = nxt;
        }
        return dummyHead.next;
    }
}