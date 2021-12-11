package algorithm.S0to100;

import datastructure.ListNode;

public class S2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode d = new ListNode(0);
        ListNode m = d;
        boolean carry = false;
        while (p1 != null || p2 != null) {
            int num1 = p1 == null ? 0 : p1.val;
            int num2 = p2 == null ? 0 : p2.val;
            int sum = (carry ? 1 : 0) + num1 + num2;
            carry = sum >= 10;
            d.next = new ListNode(sum % 10);
            d = d.next;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        if (carry) {
            d.next = new ListNode(1);
        }
        return m.next;
    }
}
