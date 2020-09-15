package algorithm;

import datastructure.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class L80_91 {

    public static void printLinkList(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    // 80
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int currentTimes = 0;
        int currentNumber = nums[0];
        boolean remove = false;
        int loc1 = 0; // 检索的位置
        int loc2 = 0; // 修改的位置

        while (loc1 < nums.length) {
            System.out.println(Arrays.toString(nums));
            System.out.println(loc1 + "  " + loc2);
            System.out.println("currentNumber" + currentNumber);
            System.out.println("currentTimes" + currentTimes);

            if (currentTimes >= 2)
                remove = true;

            if (nums[loc1] == currentNumber && remove) {
                loc1++;
                continue;
            }
            if (nums[loc1] != currentNumber) {
                remove = false;
                currentTimes = 0;
            }
            currentTimes++;
            currentNumber = nums[loc1];
            nums[loc2] = nums[loc1];
            loc2++;
            loc1++;
        }
        return loc2;

    }



    // 83
    public ListNode deleteDuplicates(ListNode head) {
        ListNode no1 = new ListNode();
        no1.next = head;
        ListNode p1 = no1;
        ListNode p2 = head;
        if (p2 == null || p2.next == null)
            return head;
        while (p2 != null && p2.next != null) {
            while (p2.next != null && p2.next.val == p1.next.val)
                p2 = p2.next;
            p1.next = p2;
            p1 = p2;
            p2 = p2.next;
        }
        return no1.next;
    }

    /*
     * 84 分治法还好理解, 就是分组计算
     */
    public int calculateArea(int[] heights, int start, int end) {
        if (start > end)
            return 0;
        int minindex = start;
        for (int i = start; i <= end; i++)
            if (heights[minindex] > heights[i])
                minindex = i;
        return Math.max(heights[minindex] * (end - start + 1),
                Math.max(calculateArea(heights, start, minindex - 1), calculateArea(heights, minindex + 1, end)));
    }

    public int largestRectangleArea2(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }

    /* 84 栈方法 */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            max = Math.max(max, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        return max;
    }

    /* 86 分割链表 */
    public ListNode partition(ListNode head, int x) {
        ListNode greater = new ListNode();
        ListNode less = new ListNode();
        ListNode p = head;
        ListNode less_head = less;
        ListNode greater_head = greater;
        while (p != null) {
            if (p.val < x) {
                less.next = p;
                less = less.next;
            } else {
                greater.next = p;
                greater = greater.next;
            }
            p = p.next;
        }
        greater.next = null;
        less.next = greater_head.next;
        return less_head.next;
    }

    /* 88 合并两个数组 */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        m--;
        n--;
        while (m >= 0 || n >= 0) {
            if (m >= 0 && n >= 0)
                nums1[i--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
            else
                nums1[i--] = n < 0 ? nums1[m--] : nums2[n--];
        }
    }

    /* 90 子集II 见78题 */

    /* 91 解码问题 就是动态规划, 变种的爬楼梯 */

    /* 89 格雷码 */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {
            private static final long serialVersionUID = 1L;

            {
                add(0);
            }
        };
        int head = 1;
        for (int i = 0; i < n; i++) {
            System.out.println(head);
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }
}
