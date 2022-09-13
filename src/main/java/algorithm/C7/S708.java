package algorithm.C7;

public class S708 {
    public Node insert(Node head, int insertVal) {
        Node n = new Node(insertVal);
        if (head == null) {
            n.next = n;
            return n;
        }
        Node q = head;
        while (q.next.val >= q.val) {
            q = q.next;
            if (q == head) {
                break;
            }
        }
        int max = q.val;
        int min = q.next.val;
        if (insertVal >= max || insertVal <= min) {
            n.next = q.next;
            q.next = n;
        } else {
            while (true) {
                if (q.val <= insertVal && q.next.val >= insertVal) {
                    n.next = q.next;
                    q.next = n;
                    break;
                }
                q = q.next;
            }
        }
        return head;
    }

    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

}
