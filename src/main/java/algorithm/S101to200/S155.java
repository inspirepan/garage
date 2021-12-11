package algorithm.S101to200;

public class S155 {
    public class MinStack {


        Node first;
        int minVal = Integer.MIN_VALUE;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            this.first = null;
        }

        public void push(int x) {
            if (this.first == null) {
                this.first = new Node(x, x);
            } else {
                int currMin = Math.min(this.first.min, x);
                Node newNode = new Node(x, currMin, this.first);
                this.first = newNode;
            }
        }

        public void pop() {
            Node t;
            if (this.first.next != null) {
                t = this.first.next;
            } else {
                t = null;
            }
            this.first = null;
            this.first = t;
        }

        public int top() {
            if (this.first != null) {
                return this.first.val;
            } else {
                return -1;
            }
        }

        public int getMin() {
            if (this.first != null) {
                return this.first.min;
            } else {
                return -1;
            }
        }
    }

    public class Node {
        int val;
        int min;
        Node next;

        Node(int val_, int min_) {
            this.val = val_;
            this.min = min_;
            this.next = null;
        }

        Node(int val_, int min_, Node next_) {
            this.val = val_;
            this.min = min_;
            this.next = next_;
        }
    }
}
