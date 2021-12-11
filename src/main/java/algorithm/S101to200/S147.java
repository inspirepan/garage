package algorithm.S101to200;

import datastructure.ListNode;

public class S147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode ptr = head;
        while (ptr.next != null) {
            int val = ptr.next.val;
            ListNode nex = ptr.next.next;
            ListNode curr = dummy;
            while (curr != ptr) {
                if (curr.next.val > val) {
                    ListNode curr_next = curr.next;
                    ListNode swap = ptr.next;
                    curr.next = swap;
                    swap.next = curr_next;
                    ptr.next = nex;
                    break;
                }
                curr = curr.next;
            }
            if (curr == ptr) {
                ptr = ptr.next;
            }
        }
        return dummy.next;
    }
}