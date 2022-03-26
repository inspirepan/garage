package algorithm.O2;

public class S30 {
    class MinStack {

        // 和716题不同的是，这道题不需要popMin这种恶心的方法，因此只需要记住最小值，不需要指定删除这个值的方法！
        // 因为是栈，所以只需要记录入栈的时候的最小值就可以了
        // 和155是一样的题

        StackNode dummyHead = new StackNode(0);

        public MinStack() {

        }

        public void push(int x) {
            StackNode node = new StackNode(x);
            if (dummyHead.next == null) {
                node.min = x;
                dummyHead.next = node;
            } else {
                node.min = Math.min(x, dummyHead.next.min);
                node.next = dummyHead.next;
                dummyHead.next = node;
            }
        }

        public void pop() {
            if (dummyHead.next != null) {
                dummyHead.next = dummyHead.next.next;
            }
        }

        public int top() {
            if (dummyHead.next == null) return 0;
            return dummyHead.next.val;
        }

        public int min() {
            if (dummyHead.next == null) return 0;
            return dummyHead.next.min;
        }

        class StackNode {
            int val;
            StackNode next;
            int min;

            StackNode(int val) {
                this.val = val;
            }
        }
    }
}
