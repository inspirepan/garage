package algorithm;

import datastructure.ListNode;
import datastructure.TreeNode;

public class S109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode slow = head, fast = head, slower = null;
        while (fast != null && fast.next != null) {
            slower = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        slower.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
