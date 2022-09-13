package algorithm.c1;

import datastructure.ListNode;

public class S148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 第一步：将链表拆成两半
        ListNode fast = head, slow = head, prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        // 第二步：将两部分的链表分别排序
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        // 第三步：合并两个有序链表
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(), l = p;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return l.next;
    }

    // 自己写的quicksort超时了
    public ListNode sortList2(ListNode head) {
        if (head == null) {
            return null;
        }
        return quicksort(head)[0];
    }

    private ListNode[] quicksort(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode greater = new ListNode();
        ListNode less = new ListNode();
        ListNode lessTail = null;
        ListNode greaterTail = null;

        while (p.next != null) {
            ListNode next = p.next;
            p.next = next.next;
            if (next.val >= head.val) {
                if (greater.next == null) {
                    greaterTail = next;
                }
                next.next = greater.next;
                greater.next = next;
            } else {
                if (less.next == null) {
                    lessTail = next;
                }
                next.next = less.next;
                less.next = next;
            }
        }
        ListNode[] result = new ListNode[2];
        ListNode[] left = quicksort(less.next);
        ListNode[] right = quicksort(greater.next);
        if (left == null && right == null) {
            result[0] = head;
            result[1] = head;
        } else if (left == null) {
            head.next = right[0];
            result[0] = head;
            result[1] = right[1];
        } else if (right == null) {
            left[1].next = head;
            result[0] = left[0];
            result[1] = head;
        } else {
            left[1].next = head;
            head.next = right[0];
            result[0] = left[0];
            result[1] = right[1];
        }
        return result;
    }
}