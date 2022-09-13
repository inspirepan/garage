package algorithm.C0;

import datastructure.ListNode;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 有序合并K链表
 * 1. 使用优先队列
 * 2. 归并法
 * @author panjx
 */
public class S23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKListsHelper(lists, 0, lists.length - 1);
    }

    private ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        return merge2Lists(mergeKListsHelper(lists, start, mid), mergeKListsHelper(lists, mid + 1, end));
    }

    public ListNode merge2Lists(ListNode list1, ListNode list2) {
        ListNode p = new ListNode();
        ListNode d = p;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                p.next = list2;
                list2 = list2.next;
            } else if (list2 == null) {
                p.next = list1;
                list1 = list1.next;
            } else {
                if (list1.val > list2.val) {
                    p.next = list2;
                    list2 = list2.next;
                } else {
                    p.next = list1;
                    list1 = list1.next;
                }
            }
            p = p.next;
        }
        return d.next;
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode dummy = new ListNode();
            ListNode p = dummy;
            PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode l1, ListNode l2) {
                    return l1.val - l2.val;
                }
            });

            for (ListNode l : lists) {
                if (l != null) {
                    pq.offer(l);
                }
            }
            while (!pq.isEmpty()) {
                ListNode q = pq.poll();
                p.next = q;
                if (q.next != null) {
                    pq.offer(q.next);
                }
                p = p.next;
            }
            return dummy.next;
        }
    }
}
