package algorithm.O2;

import datastructure.ListNode;

public class S24 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = head;
        while (p.next != null) {
            // 把a插入到dummy后面
            ListNode a = p.next;
            ListNode nextOfNext = a.next;
            a.next = dummy.next;
            dummy.next = a;
            p.next = nextOfNext;
        }
        return dummy.next;
    }
}
