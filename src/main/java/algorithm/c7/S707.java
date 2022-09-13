package algorithm.c7;

public class S707 {
    class MyLinkedList {

        private int size = 0;
        private final Node head = new Node(0);
        private final Node tail = new Node(0);
        public MyLinkedList() {
            head.next = tail;
            tail.prev = head;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            Node p = head;
            while (index-- >= 0) {
                p = p.next;
            }
            return p.val;
        }

        public void addAtHead(int val) {
            Node n = new Node(val);
            n.next = head.next;
            head.next.prev = n;
            n.prev = head;
            head.next = n;
            size++;
        }

        public void addAtTail(int val) {
            Node n = new Node(val);
            tail.prev.next = n;
            n.prev = tail.prev;
            n.next = tail;
            tail.prev = n;

            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index <= 0) {
                addAtHead(val);
            } else if (index == size) {
                addAtTail(val);
            } else if (index > 0 && index < size) {
                Node p = head;
                while (index-- > 0) {
                    p = p.next;
                }
                Node n = new Node(val);
                p.next.prev = n;
                n.next = p.next;
                n.prev = p;
                p.next = n;
                size++;
            }
        }

        public void deleteAtIndex(int index) {
            if (index >= size || index < 0) {
                return;
            }
            Node p = head;
            while (index-- > 0) {
                p = p.next;
            }
            p.next.next.prev = p;
            p.next = p.next.next;
            size--;
        }

        class Node {
            int val;
            Node next;
            Node prev;

            public Node(int _val) {
                this.val = _val;
                this.next = null;
                this.prev = null;
            }

            public Node(int _val, Node _next, Node _prev) {
                this.val = _val;
                this.next = _next;
                this.prev = _prev;
            }
        }
    }
}
