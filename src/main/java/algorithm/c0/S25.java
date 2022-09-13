package algorithm.c0;

import datastructure.ListNode;

public class S25 {

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode p = dummy;

            while (true) {
                int count = 0;
                ListNode q = p;
                while (p.next != null && count < k) {
                    p = p.next;
                    count++;
                }
                if (count < k) {
                    // 不足k个（可能0个），返回结果
                    return dummy.next;
                }
                p = reverse(q, p.next);
            }
        }

        ListNode reverse(ListNode start, ListNode tail) {
            // 翻转dummy之后直到tail（不包括tail）的链表，返回翻转部分的tail
            ListNode p = start.next;
            while (p.next != tail) {
                ListNode nn = p.next.next;
                p.next.next = start.next;
                start.next = p.next;
                p.next = nn;
            }
            return p;
        }
    }
}
