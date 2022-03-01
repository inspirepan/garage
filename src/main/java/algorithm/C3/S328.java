package algorithm.C3;

import datastructure.ListNode;

public class S328 {
    public ListNode oddEvenList(ListNode head) {
        // 写法和HashMapResize的尾插法差不多哈
        ListNode oHead = new ListNode();
        ListNode o = oHead;
        ListNode eHead = new ListNode();
        ListNode e = eHead;
        ListNode p = head;
        boolean odd = true;
        while (p != null) {
            ListNode next = p.next;
            if (odd) {
                o.next = p;
                o = o.next;
            } else {
                e.next = p;
                e = e.next;
            }
            odd = !odd;
            p = next;
        }

        o.next = eHead.next;
        e.next = null;
        return oHead.next;
    }
}
