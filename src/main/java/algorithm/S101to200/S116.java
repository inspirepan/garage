package algorithm.S101to200;

import datastructure.Node;

public class S116 {
    public Node connect(Node root) {
        if (root == null)
            return null;
        else if (root.left == null)
            return root;
        root.left.next = root.right;
        if(root.next!=null)
            root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }

}