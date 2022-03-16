package datastructure;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public final int val;
    public Node left;
    public Node right;
    public Node next;
    public List<Node> neighbors;
    public List<Node> children;

    public Node() {
        val = 0;
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}