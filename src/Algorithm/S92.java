package Algorithm;

import DataStructure.ListNode;

public class S92 {

    /* 反转链表2 */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode before_head = new ListNode();
        before_head.next = head;
        ListNode pre = before_head;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        head = pre.next;
        for (int i = m; i < n; i++) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return before_head.next;
    }
}