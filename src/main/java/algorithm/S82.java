package algorithm;

import datastructure.ListNode;

public class S82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // q 用于连接下一新数值
        // p 表示当前正在判断的结点
        ListNode q = dummyHead;
        ListNode p = head;
        int currValue = head.val;
        while (p.next != null) {
            int nextValue = p.next.val;
            if (nextValue != currValue) {
                // 当前结点不重复，接上
                q.next = p;
                q = q.next;
                currValue = nextValue;
            } else {
                // 重复，移动到下一个新结点
                while (p.next != null && p.next.val == currValue) {
                    p = p.next;
                }
                if (p.next != null) {
                    // 修改比较用的数值currValue
                    currValue = p.next.val;
                } else {
                    // 移动到了最后，直接返回结果
                    q.next = null;
                    return dummyHead.next;
                }
            }
            p = p.next;
        }
        // 补上最后一个结点
        q.next = p;
        q.next.next = null;
        return dummyHead.next;
    }
}
