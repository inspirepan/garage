package algorithm.f1;

import datastructure.ListNode;

public class S06 {
    public int[] reversePrint(ListNode head) {
        ListNode p = head;
        int size = 0;
        while (p != null) {
            size++;
            p = p.next;
        }
        int[] result = new int[size];
        if (size == 0) {
            return result;
        }
        p = head;
        while (p != null) {
            result[--size] = p.val;
            p = p.next;
        }
        return result;
    }
}
