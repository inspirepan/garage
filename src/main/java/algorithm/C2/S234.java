package algorithm.C2;

import datastructure.ListNode;

public class S234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        ListNode dummy = new ListNode();
        dummy.next = head;
        var slow = dummy;
        var fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        reverse(slow);
        while (slow.next != null) {
            dummy = dummy.next;
            slow = slow.next;
            if (slow.val != dummy.val) return false;
        }
        return true;
    }

    /**
     * 翻转dummy之后的部分
     */
    private void reverse(ListNode dummy) {
        if (dummy.next == null) return;
        ListNode p = dummy.next;
        while (p.next != null) {
            // 把p的next插入到dummy后面
            ListNode temp = dummy.next;
            dummy.next = p.next;
            p.next = p.next.next;
            dummy.next.next = temp;
        }
    }
}
