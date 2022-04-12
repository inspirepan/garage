package algorithm.C3;

import datastructure.ListNode;

import java.util.Random;

public class S382 {
    class Solution {
        private ListNode head;

        public Solution(ListNode head) {
            this.head = head;
        }

        public int getRandom() {
            int res = head.val;
            ListNode no = head.next;
            int i = 2;
            Random random = new Random();
            while (no != null) {
                // 还是遍历整个链表啊，每个节点
                // 如果是0，那么替换
                if (random.nextInt(i) == 0) {
                    res = no.val;
                }
                i++;
                no = no.next;
            }
            return res;
        }
    }
}
