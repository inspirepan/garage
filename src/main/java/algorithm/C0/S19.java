package algorithm.C0;

import datastructure.ListNode;

public class S19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = new ListNode(0);
        fast.next = head;
        ListNode d = fast;
        ListNode slow = fast;

        // 先让fast跑n步
        while (fast != null) {
            fast = fast.next;
            if (n == -1) {
                slow = slow.next;
            }
            if (n > -1) {
                n--;
            }
        }
        slow.next = slow.next.next;
        return d.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode p = dummyHead;
        int size = 0;
        while (p.next != null) {
            p = p.next;
            size++;
        }
        int t = size - n;
        p = dummyHead;
        while (t-- > 0) {
            p = p.next;
        }
        p.next = p.next.next;
        return dummyHead.next;
    }
}
