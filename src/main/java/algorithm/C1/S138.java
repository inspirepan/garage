package algorithm.C1;

import java.util.HashMap;
import java.util.Map;


public class S138 {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Map<Node, Node> nodeMap = new HashMap<>();
        Node ptr = head;
        while (ptr != null) {
            nodeMap.put(ptr, new Node(ptr.val));
            ptr = ptr.next;
        }
        ptr = head;
        while (ptr != null) {
            nodeMap.get(ptr).next = nodeMap.get(ptr.next);
            nodeMap.get(ptr).random = ptr.random == null ? null : nodeMap.get(ptr.random);
            ptr = ptr.next;
        }
        return nodeMap.get(head);
    }

    static class Node {
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