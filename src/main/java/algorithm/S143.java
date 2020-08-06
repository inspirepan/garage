package algorithm;

import datastructure.ListNode;

public class S143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // 使用快慢指针，找到中点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 翻转中点后面部分的链表
        ListNode beforeReverse = slow.next;
        slow.next = null;
        ListNode afterReverse = null;
        ListNode nextToReverse = beforeReverse;
        while (beforeReverse != null) {
            nextToReverse = beforeReverse.next;
            beforeReverse.next = afterReverse;
            afterReverse = beforeReverse;
            beforeReverse = nextToReverse;
        }
        // 两条交叉
        ListNode ptrHead = head;
        while (ptrHead != null && afterReverse != null) {
            ListNode ptrTemp = afterReverse;
            afterReverse = afterReverse.next;
            ListNode ptrNext = ptrHead.next;
            ptrTemp.next = ptrNext;
            ptrHead.next = ptrTemp;
            ptrHead = ptrNext;
        }
    }
}