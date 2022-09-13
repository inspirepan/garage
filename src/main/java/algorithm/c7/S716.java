package algorithm.c7;

import java.util.ArrayList;
import java.util.List;

public class S716 {
    class MaxStack {

        int max = Integer.MIN_VALUE;
        Node head = new Node(0);
        Node tail = new Node(0);
        List<Node> list = new ArrayList<>();
        public MaxStack() {
            // 栈好说，维护一个链表、有栈顶元素就可以了
            // 维护一个有序列表，使用二分搜索找增删的节点，o(logn)
            head.next = tail;
            tail.prev = head;
        }

        public void push(int x) {
            Node n = new Node(x);
            n.next = head.next;
            head.next.prev = n;
            head.next = n;
            n.prev = head;
            // list
            int index = search(x);
            list.add(index, n);
            max = list.get(list.size() - 1).val;
        }

        private int search(int x) {
            int left = 0;
            int right = list.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                int midVal = list.get(mid).val;
                if (midVal > x) {
                    right = mid;
                } else if (midVal < x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }

        public int pop() {
            // 栈
            int val = head.next.val;
            head.next = head.next.next;
            head.next.prev = head;
            // list
            int index = search(val);
            list.remove(index);
            if (list.size() > 0) {
                max = list.get(list.size() - 1).val;
            }
            return val;
        }

        public int top() {
            return head.next.val;
        }

        public int peekMax() {
            return max;
        }

        public int popMax() {
            int t = max;
            int index = search(max);
            Node n = list.get(index);
            n.next.prev = n.prev;
            n.prev.next = n.next;
            list.remove(index);
            if (list.size() > 0) {
                max = list.get(list.size() - 1).val;
            }
            return t;
        }

        class Node {
            int val;
            Node next;
            Node prev;

            public Node(int val) {
                this.val = val;
            }
        }
    }
}
