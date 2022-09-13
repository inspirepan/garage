package algorithm.c2;

import datastructure.ListNode;

public class S237 {
    public void deleteNode(ListNode node) {
        if (node.next == null) {
            node = null;
        } else {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
