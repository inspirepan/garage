package algorithm.C1;

import datastructure.Node;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 思路还是层级往下连接
 * 注意实现层序需要一个queue，不能够直接递归，因为只有一层的next完成连接，才能够正确找到下一行
 * 啊蠢了蠢了，明明实现了一个next为什么还要用queue来保存下一个呢？
 */
public class S117 {

    /**
     * 用一个dummy和node表示下一层的结点，迭代到下一层就是就是dummy.next
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        while (cur != null) {
            Node dummy = new Node();
            Node node = dummy;
            while (cur != null) {
                if (cur.left != null) {
                    node.next = cur.left;
                    node = node.next;
                }
                if (cur.right != null) {
                    node.next = cur.right;
                    node = node.next;
                }
                cur = cur.next;
            }
            //下一层
            cur = dummy.next;
        }
        return root;
    }

    /**
     * 自己写的麻烦方法
     */
    public Node connect2(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node node;
        while (!queue.isEmpty()) {
            if ((node = queue.poll()) != null) {
                connectNode(node);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return root;
    }

    private void connectNode(Node node) {
        Node nxt = findNext(node);
//        System.out.println(nxt == null ? "#" : nxt.val);
        if (node.left != null && node.right != null) {
            node.left.next = node.right;
            node.right.next = nxt;
        } else if (node.left != null) {
            node.left.next = nxt;
        } else if (node.right != null) {
            node.right.next = nxt;
        }
    }

    private Node findNext(Node node) {
        Node temp = node.next;
        Node nxt;
        while (temp != null && temp.left == null && temp.right == null) {
            temp = temp.next;
        }
        if (temp == null) {
            nxt = null;
        } else if (temp.left != null) {
            nxt = temp.left;
        } else {
            nxt = temp.right;
        }
        return nxt;
    }
}
