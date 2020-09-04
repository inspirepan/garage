package algorithm;

import datastructure.ListNode;

/**
 * 反转链表系列
 * 24. 反转相邻链表
 * 25. 反转K个一组的链表
 *
 * @author panjx
 */
public class reverseList {
    /**
     * 24
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode p = dummyHead;
        while (p.next != null) {
            ListNode nxt1 = p.next;
            if (nxt1.next == null) {
                break;
            }
            ListNode nxt2 = nxt1.next;
            p.next = nxt2;
            nxt1.next = nxt2.next;
            nxt2.next = nxt1;
            p = nxt1;
        }
        return dummyHead.next;
    }

    /**
     * 25
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode p = dummyHead;
        while (p.next != null) {
            if (!hasKLeft(p, k)) {
                break;
            }
            p = reverseNextK(p, k);
        }
        return dummyHead.next;
    }

    private boolean hasKLeft(ListNode prev, int k) {
        ListNode p = prev;
        // 操作k次
        while (k-- > 0) {
            // 不足k个
            if (p.next == null) {
                return false;
            }
            p = p.next;
        }
        return true;
    }

    /**
     * 反转prev后面的k个结点，并把p置于反转后的最后一个结点
     * prev->1->2->3->4
     *
     * @param prev 初始结点
     * @param k    反转数量
     */
    public ListNode reverseNextK(ListNode prev, int k) {
        ListNode a = prev.next;
        // 操作 k-1 次
        while (--k > 0) {
            ListNode nxt = a.next;
            a.next = nxt.next;
            nxt.next = prev.next;
            prev.next = nxt;
        }
        return a;
    }
}
