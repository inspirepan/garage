package algorithm.C3;

import datastructure.ListNode;

public class S328 {
    public ListNode oddEvenList(ListNode head) {
        // 写法和HashMapResize的尾插法差不多哈`
        ListNode odd = new ListNode();
        ListNode a = odd;
        ListNode even = new ListNode();
        ListNode b = even;
        ListNode p = head;
        boolean isOdd = true;
        while (p != null) {
            ListNode next = p.next;
            if (isOdd) {
                a.next = p;
                a = a.next;
            } else {
                b.next = p;
                b = b.next;
            }
            isOdd = !isOdd;
            p = next;
        }

        a.next = even.next;
        b.next = null;
        return odd.next;
    }
}
