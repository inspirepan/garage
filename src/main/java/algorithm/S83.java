package algorithm;

import datastructure.ListNode;

public class S83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.val != p.next.val) {
                p = p.next;
            } else {
                ListNode temp = p.next;
                while (temp != null && temp.val == p.val) {
                    temp = temp.next;
                }
                p.next = temp;
            }
        }
        return head;
    }
}
