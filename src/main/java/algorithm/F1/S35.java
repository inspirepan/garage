package algorithm.F1;

import java.util.HashMap;
import java.util.Map;

public class S35 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        if (head == null) {
            return null;
        }
        Node n = new Node(head.val);
        map.put(head, n);
        Node p = n;
        Node q = head;
        while (q.next != null) {
            q = q.next;
            Node k = new Node(q.val);
            p.next = k;
            map.put(q, k);
            p = p.next;
        }
        p.next = null;
        p = n;
        if (head.random != null) {
            p.random = map.get(head.random);
        } else {
            p.random = null;
        }
        while (head.next != null) {
            head = head.next;
            p = p.next;
            if (head.random != null) {
                p.random = map.get(head.random);
            } else {
                p.random = null;
            }
        }
        return n;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
