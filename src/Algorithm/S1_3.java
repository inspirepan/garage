package Algorithm;

import DataStructure.ListNode;

import java.util.HashMap;
import java.util.Map;

/* 4.6 */

public class S1_3 {

    /*
     * 1 哈希表
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(target - nums[i]))
                return new int[] { m.get(target - nums[i]), i };
            m.put(nums[i], i);
        }
        throw new IllegalArgumentException("No Answer");
    }

    /* 2 */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 这道题应该讲清楚 l1，l2 是头结点吧
        ListNode r = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = r;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p == null) ? 0 : p.val;// 问号条件句，要熟练
            int y = (q == null) ? 0 : q.val;
            int sum = x + y + carry;
            carry = (sum >= 10) ? 1 : 0;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) { // 这里的条件应该是 p!=null 而不是 p.next!=null，因为 while 循环用的是一个或条件
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(1);
        }
        return r.next; // 容易忘记要返回next
    }

    /*
     * 3 这道题的思想要记住啊，相当于对每个可能出现的字符做统计
     */
    public int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        int[] index = new int[128];
        int i = 0;
        int max = 0;
        int tail = 0;
        int count = 0;
        for (i = 0; i < c.length; i++) {
            if (index[c[i]] > tail) {
                count = i - tail;
                if (count > max)
                    max = count;
                tail = index[c[i]];
            }
            index[c[i]] = i + 1;
        }
        count = i - tail;
        return count > max ? count : max;
    }
}
