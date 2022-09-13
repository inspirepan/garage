package algorithm.c7;

import datastructure.ListNode;

public class S725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        ListNode p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        int mod = count % k;
        // mod平分
        int size = count / k;
        ListNode[] res = new ListNode[k];
        p = head;
        for (int i = 0; i < k && p != null; i++) {
            res[i] = p;
            int temp = size + (mod-- > 0 ? 1 : 0);
            for (int j = 1; j < temp; j++) {
                p = p.next;
            }
            // 断开p和next
            ListNode next = p.next;
            p.next = null;
            p = next;
        }
        return res;
    }
}
